//package com.iscas.smurfs.cache.aspect;
//
//import com.google.gson.Gson;
//import com.iscas.smurfs.cache.annotation.Cache;
//import com.iscas.smurfs.common.utils.JsonUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//
///**
// * description:
// *
// * @author lee
// * @date 2018/9/13
// */
//@Aspect
//@Service
//@Slf4j
//public class CacheAspect {
//    @Pointcut("@annotation(com.iscas.smurfs.cache.annotation.Cache)")
//    public void aspect() {
//    }
//
//    @Around("aspect()&&@annotation(anno)")
//    public Object interceptor(ProceedingJoinPoint invocation, Cache anno){
//        MethodSignature signature = (MethodSignature) invocation.getSignature();
//        Method method = signature.getMethod();
//        Object result = null;
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        Object[] arguments = invocation.getArgs();
//        Type returnType = method.getGenericReturnType();
//        log.info(anno.key()+"############");
//
//        result = JsonUtils.fromJson("{\"password\":\"kjljkj\",\"username\":\"123\"}",returnType);
//
//        return result;
//    }
//
//
//}
