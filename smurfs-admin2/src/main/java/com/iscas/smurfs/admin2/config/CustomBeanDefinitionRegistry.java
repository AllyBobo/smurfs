//package com.iscas.smurfs.admin2.config;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.*;
//import org.springframework.context.support.AbstractRefreshableApplicationContext;
//
//import javax.sql.DataSource;
//
///**
// * @author: lee
// * @date: 2018-11-01
// */
//public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//
//    }
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        GenericBeanDefinition definition = new GenericBeanDefinition();
//        definition.setBeanClass(DataSource.class);    //设置类
//        definition.setScope("singleton");       //设置scope
//        definition.setLazyInit(false);          //设置是否懒加载
//        definition.setAutowireCandidate(true);  //设置是否可以被其他对象自动注入
//        configurableListableBeanFactory.registerSingleton("datasource",definition);
//    }
//
//}
