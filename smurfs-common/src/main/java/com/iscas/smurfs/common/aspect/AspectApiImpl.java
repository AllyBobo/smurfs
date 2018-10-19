package com.iscas.smurfs.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @author: lee
 * @date: 2018-10-19
 */
@Service
public class AspectApiImpl implements AspectApi {
    @Override
    public Object doHandlerAspect(ProceedingJoinPoint pjp, Method method) throws Throwable {
        return null;
    }
}
