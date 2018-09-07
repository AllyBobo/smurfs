package com.iscas.smurfs.zuul.filter;

import com.google.gson.reflect.TypeToken;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.core.entity.Permission;
import com.iscas.smurfs.zuul.remote.DbRemote;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class PreRequestFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestFilter.class);

    @Autowired
    DbRemote dbRemote;

    @Value("${zuul.prefix}")
    private String zuulPrefix;

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
        PreRequestFilter.LOGGER.info(String.format(" send %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());;
        final String method = request.getMethod();
        //白名单
        if (isStartWith(requestUri)) {
            return null;
        }

        List<Permission> permissions = JsonUtils.fromJson(dbRemote.getAllPermissions(),new TypeToken<List<Permission>>(){}.getType());
        List<Permission> result = permissions.parallelStream().filter(new Predicate<Permission>() {
            @Override
            public boolean test(Permission permission) {
                String url = permission.getUri();
                String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                String regEx = "^" + uri + "$";
                return (Pattern.compile(regEx).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                        && method.equals(permission.getMethod());
            }
        }).collect(Collectors.toList());

        //该地址不受权限管理
        if (result==null || result.isEmpty()){
            return null;
        }

        String authToken = request.getHeader(Constant.TOKEN_HEADER);
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter(Constant.TOKEN_HEADER);
        }
        ctx.addZuulRequestHeader(Constant.TOKEN_HEADER,authToken);


        return null;
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
}
