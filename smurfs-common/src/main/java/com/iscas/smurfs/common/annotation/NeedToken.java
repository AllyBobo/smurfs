package com.iscas.smurfs.common.annotation;

import java.lang.annotation.*;

/**
 * description:
 * 访问此方法需要token
 * @author lee
 * @date 2018/10/25
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface NeedToken {
}
