package com.iscas.smurfs.common.config;

import com.iscas.smurfs.common.annotation.Log;
import com.iscas.smurfs.common.aspect.AspectApi;
import com.iscas.smurfs.common.aspect.DecoratorLogAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author: lee
 * @date: 2018-10-19
 */

@Aspect
@Configuration
public class AspectConfiguration {
    //创建被装饰者
    @Autowired
    AspectApi aspectApi;
   @Pointcut("@annotation(com.iscas.smurfs.common.annotation.Log)")
    public void aspect() {
    }

    @Around(value = "aspect()")
    public Object validationPoint(ProceedingJoinPoint pjp)throws Throwable{
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Object result = pjp.proceed();
        //加了日志注解
        if(method.isAnnotationPresent(Log.class)){
            new DecoratorLogAspect(aspectApi).doHandlerAspect(pjp,method);
        }
        return  result;
    }

}
