package com.iscas.smurfs.common.config;

import com.iscas.smurfs.common.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/24
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //registration.setFilter(new SessionFilter());//这种方式，filter里的@Autoware会是null，原因是啥？？
        registration.setFilter(this.sessionFilter());//添加过滤器
        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("SessionFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        return registration;
    }

    @Bean
    public Filter sessionFilter() {
        return new SessionFilter();
    }
}
