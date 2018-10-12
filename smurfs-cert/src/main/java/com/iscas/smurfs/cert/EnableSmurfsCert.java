package com.iscas.smurfs.cert;

import com.iscas.smurfs.cert.config.AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableSmurfsCert {
}