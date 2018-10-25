package com.iscas.smurfs.common.filter;

import com.iscas.smurfs.common.config.KeyConfiguration;
import com.iscas.smurfs.common.config.UserConfiguration;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.context.CustomSession;
import com.iscas.smurfs.common.entity.dto.UserJwtDto;
import com.iscas.smurfs.common.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/24
 */
public class SessionFilter implements Filter {

    @Autowired
    UserConfiguration userConfiguration;
    @Autowired
    KeyConfiguration keyConfiguration;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        //判断客户端是普通用户而不是服务
        if(httpServletRequest.getHeader(Constant.CLIENT_TAG)==null) {
            //TODO:加个注解，判断访问的是受限资源
            String token = httpServletRequest.getHeader(userConfiguration.getTokenHeader());
            try {
                UserJwtDto userJwtDto = JwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
                CustomSession.setUserID(userJwtDto.getUserId().toString());
                CustomSession.setName(userJwtDto.getName());
                CustomSession.setUsername(userJwtDto.getUsername());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        CustomSession.remove();
    }
}
