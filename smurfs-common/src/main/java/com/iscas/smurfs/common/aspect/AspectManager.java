package com.iscas.smurfs.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author: lee
 * @date: 2018-10-19
 */
public abstract class AspectManager implements AspectApi{

    @Override
    public abstract Object doHandlerAspect(ProceedingJoinPoint pjp, Method method)throws Throwable;

}

