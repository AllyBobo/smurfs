package com.iscas.smurfs.cache.aspect;

import com.iscas.smurfs.cache.annotation.Cache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/13
 */
@Aspect
@Service
@Slf4j
public class CacheAspect {
    @Pointcut("@annotation(com.iscas.smurfs.cache.annotation.Cache)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, Cache anno){
        log.info(anno.key()+"############");
        Object result = new Object();
        return result;
    }
}
