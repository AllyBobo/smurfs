package com.iscas.smurfs.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface Cache {
    public String key() default "";

    public int expire() default 720;

    public String desc() default "";

    public Class[] result() default Object.class;
}

