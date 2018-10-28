/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.iscas.smurfs.common.utils;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 *
 * @author Zaric
 * @date 2013-5-29 下午1:25:40
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
	private static ApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		context = applicationContext;
	}

	public static <T> T getBean(String name)
	{
		return (T)context.getBean(name);
	}

	public static <T> T getBean(Class<T> beanClass){
		return context.getBean(beanClass);
	}
}