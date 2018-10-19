package com.iscas.smurfs.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import java.lang.reflect.Method;
import com.iscas.smurfs.common.annotation.Log;

/**
 * @author: lee
 * @date: 2018-10-19
 */
@Slf4j
public class DecoratorLogAspect extends AspectManager {

    private AspectApi aspectApi;

    public DecoratorLogAspect(AspectApi aspectApi){
        super();
        this.aspectApi=aspectApi;
    }

    @Override
    public Object doHandlerAspect(ProceedingJoinPoint pjp, Method method) throws Throwable {
        aspectApi.doHandlerAspect(pjp, method);
        Log mylog = method.getAnnotation(Log.class);
        String description = mylog.description();
        log.info("Function accessed ====== " + method.getName() + description);
        return null;

    }
}

