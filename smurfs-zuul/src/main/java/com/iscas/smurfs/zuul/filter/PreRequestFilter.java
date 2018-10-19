package com.iscas.smurfs.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.iscas.smurfs.cert.service.UserJwtService;
import com.iscas.smurfs.common.entity.dto.ResponseCode;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.entity.dto.TokenForbiddenResponse;
import com.iscas.smurfs.core.admin.entity.dto.UserJwtDto;
import com.iscas.smurfs.core.admin.entity.po.Permission;
import com.iscas.smurfs.zuul.feign.IAdminFeign;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class PreRequestFilter extends ZuulFilter {

    @Autowired
    @Lazy
    IAdminFeign adminFeign;
    @Autowired
    @Lazy
    UserJwtService userJwtService;

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format(" send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
        final String requestUri = request.getRequestURI();

        final String method = request.getMethod();
        //白名单
        if (isStartWith(requestUri)) {
            return null;
        }

        List<Permission> permissions = JSON.parseObject(adminFeign.getAllPermissions(),new TypeReference<List<Permission>>(){});
        List<Permission> result = permissions.parallelStream().filter(new Predicate<Permission>() {
            @Override
            public boolean test(Permission permission) {
                String url = permission.getUri();
                String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                //String regEx = "^" + uri + "$";
                return (Pattern.compile(uri).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                        && method.equals(permission.getMethod());
            }
        }).collect(Collectors.toList());

        //该地址不受权限管理
        if (result==null || result.isEmpty()){
            return null;
        }
        UserJwtDto userJwtDto = null;
        try{
            userJwtDto = getUserJwtInfo(ctx, request);
            if (userJwtDto==null){
                //没有用户信息
                setFailedRequest(JSON.toJSONString(new TokenForbiddenResponse("Token Forbidden!")),ResponseCode.SUCCESS_CODE.getCode());
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Boolean isPermission = false;

        for(Permission permission : permissions){
            isPermission = adminFeign.checkUserAndPermission(userJwtDto.getUserId(),permission.getId());
            if (isPermission.equals(true)) break;
        }
        //没有授权
        if(!isPermission){
            setFailedRequest(JSON.toJSONString(new TokenForbiddenResponse("Token Forbidden!")),ResponseCode.SUCCESS_CODE.getCode());
        }else {
            ctx.addZuulRequestHeader("userId", userJwtDto.getUserId().toString());
            ctx.addZuulRequestHeader("userName", URLEncoder.encode(userJwtDto.getName()));
        }
        return null;
    }

    private UserJwtDto getUserJwtInfo(RequestContext ctx, HttpServletRequest request) throws Exception {
        String authToken = request.getHeader(Constant.TOKEN_HEADER);
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter(Constant.TOKEN_HEADER);
        }
        if(authToken == null) return null;
        ctx.addZuulRequestHeader(Constant.TOKEN_HEADER,authToken);
        // 从token中计算出来user
        return userJwtService.getInfoFromToken(authToken);
    }

    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    private void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }
}
