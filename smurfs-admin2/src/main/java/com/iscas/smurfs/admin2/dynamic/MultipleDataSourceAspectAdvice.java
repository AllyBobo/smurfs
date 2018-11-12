package com.iscas.smurfs.admin2.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author: lee
 * @date: 2018-11-12
 */
@Component
@Aspect
@Slf4j
public class MultipleDataSourceAspectAdvice implements Ordered {
    @Before("execution(* com..mapper..*.*(..))")
    public void changeDataSource(JoinPoint point) throws Throwable {
        String environmentCode = "dev";// SessionUtil.getSessionAttr(SessionUtil.ENVIRONMENT_CODE,"dev").toString();
        log.info("Use DataSource : "+ environmentCode+"-"+ point.getSignature());
        DynamicDataSourceContextHolder.setDataSourceType(environmentCode);
    }

    @After("execution(* com..service..*.*(..))")
    public void clearDataSource2(JoinPoint point) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
    @After("execution(* com..mapper..*.*(..))")
    public void clearDataSource(JoinPoint point) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
    @Before("execution(* com..service..*.*(..))")
    public void switchDataSource(JoinPoint point) throws Throwable {
        String environmentCode ="dev";//= SessionUtil.getSessionAttr(SessionUtil.ENVIRONMENT_CODE,"dev").toString();
        log.info("Use DataSource : "+ environmentCode+"-"+ point.getSignature());
        DynamicDataSourceContextHolder.setDataSourceType(environmentCode);
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
