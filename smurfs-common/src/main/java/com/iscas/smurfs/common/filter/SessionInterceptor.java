package com.iscas.smurfs.common.filter;

import com.iscas.smurfs.common.annotation.NeedToken;
import com.iscas.smurfs.common.config.KeyConfiguration;
import com.iscas.smurfs.common.config.UserConfiguration;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.context.CustomSession;
import com.iscas.smurfs.common.entity.dto.UserJwtDto;
import com.iscas.smurfs.common.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/25
 */
@Service
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserConfiguration userConfiguration;
    @Autowired
    KeyConfiguration keyConfiguration;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        //判断客户端是普通用户而不是服务
        if(request.getHeader(Constant.CLIENT_TAG)==null) {
            NeedToken needToken = handlerMethod.getBeanType().getAnnotation(NeedToken.class);
            if (needToken!=null) {
                String token = request.getHeader(userConfiguration.getTokenHeader());
                try {
                    UserJwtDto userJwtDto = JwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
                    CustomSession.setUserID(userJwtDto.getUserId().toString());
                    CustomSession.setName(userJwtDto.getName());
                    CustomSession.setUsername(userJwtDto.getUsername());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CustomSession.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
