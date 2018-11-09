//package com.iscas.smurfs.admin2.config;
//
///**
// * @author: lee
// * @date: 2018-11-09
// */
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
///**
// * 这里的conditional是一个可选条件，表示当这个表达式为true的时候，才动态创建bean
// */
////@ConditionalOnExpression("${my.configuration.enabled}")
//public class DynamicConfiguration
//{
//
//    /**
//     * 这个方法返回Runnable只是一个幌子，最重要的是执行方法里面的代码
//     */
//    @Bean
//    public Runnable dynamicConfiguration() throws Exception
//    {
//        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
//        ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)context.getBeanFactory();
//
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(UserxxxService.class);
//        /**
//         * 设置属性
//         */
//        beanDefinitionBuilder.addPropertyValue("name", "myConfigure");
//        beanDefinitionBuilder.addPropertyValue("jdbcTemplate", applicationContext.getBean(JdbcTemplate.class));
//
//        /**
//         * 注册到spring容器中
//         */
//        beanFactory.registerBeanDefinition("userxxxService", beanDefinitionBuilder.getBeanDefinition());
//        return null;
//    }
//}
