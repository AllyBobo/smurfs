package com.iscas.smurfs.common.annotation;

import java.lang.annotation.*;

@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface Log {
    String description() default "";
}
