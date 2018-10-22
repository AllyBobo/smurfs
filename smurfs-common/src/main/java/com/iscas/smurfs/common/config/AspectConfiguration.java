package com.iscas.smurfs.common.config;

import com.iscas.smurfs.common.annotation.Log;
import com.iscas.smurfs.common.aspect.AspectApi;
import com.iscas.smurfs.common.aspect.DecoratorLogAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
   @Pointcut("execution(* com.iscas.smurfs.*.biz..*.*(..))")
    public void aspect() {
    }

    @Around(value = "aspect()")
    public Object validationPoint(ProceedingJoinPoint pjp)throws Throwable{
        Method method = currentMethod(pjp,pjp.getSignature().getName());
        //是否需要记录日志
        if(method.isAnnotationPresent(Log.class)){
            return new DecoratorLogAspect(aspectApi).doHandlerAspect(pjp,method);
        }
        return  pjp.proceed(pjp.getArgs());
    }

    /**
     * 获取目标类的所有方法，找到当前要执行的方法
     */
    private Method currentMethod ( ProceedingJoinPoint joinPoint , String methodName ) {
        Method[] methods      = joinPoint.getTarget().getClass().getMethods();
        Method   resultMethod = null;
        for ( Method method : methods ) {
            if ( method.getName().equals( methodName ) ) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

}
