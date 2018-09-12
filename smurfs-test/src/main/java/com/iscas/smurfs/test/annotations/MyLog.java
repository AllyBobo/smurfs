package com.iscas.smurfs.test.annotations;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/12
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value();
}