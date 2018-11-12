//package com.iscas.smurfs.admin2.config;
//
//import com.iscas.smurfs.admin2.controller.TableMetaController;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.AbstractRefreshableApplicationContext;
//import org.springframework.stereotype.Service;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: lee
// * @date: 2018-11-09
// */
//@Configuration
//public class DynamicDataSource{
//
//    public void addBean(String beanName, Class beanClass, Map map) throws ClassNotFoundException {
//        // 获取bean工厂并转换为DefaultListableBeanFactory
//        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringUtils.getApplicationContext();
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
//        //BeanDefinitionRegistry beanDefReg = (DefaultListableBeanFactory) ctx.getBeanFactory();
//        //DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)ctx.getBeanFactory();
//        BeanDefinitionBuilder beanDefBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
//        BeanDefinition beanDef = beanDefBuilder.getBeanDefinition();
//        if (!beanFactory.containsBeanDefinition(beanName)) {
//            beanFactory.registerBeanDefinition("DataSource", BeanDefinitionBuilder.genericBeanDefinition(beanClass)
//                    .setScope("prototype").addPropertyValue("url",map.get("url"))
//                    .addPropertyValue("username",map.get("username"))
//                    .addPropertyValue("password",map.get("password"))
//                    .addPropertyValue("driverClassName",map.get("driverClassName")).getRawBeanDefinition());
//        }
//    }
//
//    public void removeBean(String beanName) {
//        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) SpringUtils.getApplicationContext();
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
//        //BeanDefinitionRegistry beanDefReg = (DefaultListableBeanFactory) ctx.getBeanFactory();
//        beanFactory.getBeanDefinition(beanName);
//        beanFactory.removeBeanDefinition(beanName);
//    }
//
//    public void showAllBeans() {
//        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) SpringUtils.getApplicationContext();
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
//        System.out.println(beanFactory.containsBean("dynamicDataSource"));
//
//        //遍历
//        for (String name : beanFactory.getBeanDefinitionNames()) {
//            System.out.println("name->" + name + "======,class->" + SpringUtils.getBean(name).getClass());
//        }
//    }
//
//}