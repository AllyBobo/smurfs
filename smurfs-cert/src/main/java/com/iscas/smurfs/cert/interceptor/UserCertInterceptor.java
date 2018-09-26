//package com.iscas.smurfs.cert.interceptor;
//
//import com.iscas.smurfs.cert.annotation.ProtectedSystem;
//import com.iscas.smurfs.cert.config.UserAuthConfig;
//import com.iscas.smurfs.cert.jwt.UserAuthUtil;
//import com.iscas.smurfs.core.entity.JWTInfo;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * description:
// *
// * @author 123
// * @date 2018/9/26
// */
//public class UserCertInterceptor implements HandlerInterceptor {
//    @Autowired
//    private UserAuthConfig userAuthConfig;
//    @Autowired
//    private UserAuthUtil userAuthUtil;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        if (handlerMethod.getBeanType().getAnnotation(ProtectedSystem.class)==null
//                && handlerMethod.getMethodAnnotation(ProtectedSystem.class)==null){
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
//                           ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                                Object o, Exception e) throws Exception {
//
//    }
//}
