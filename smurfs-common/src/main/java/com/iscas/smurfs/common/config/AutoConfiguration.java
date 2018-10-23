package com.iscas.smurfs.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/15
 */
@ComponentScan({"com.iscas.smurfs.common"})
@EnableAspectJAutoProxy//(exposeProxy = true)
public class AutoConfiguration {

}
