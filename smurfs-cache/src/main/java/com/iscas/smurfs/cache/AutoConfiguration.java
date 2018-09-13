package com.iscas.smurfs.cache;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ace
 * @create 2017/11/17.
 */
@ComponentScan({"com.iscas.smurfs.cache"})
@EnableAspectJAutoProxy//(exposeProxy = true)
public class AutoConfiguration {

}
