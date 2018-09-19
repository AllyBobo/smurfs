package com.iscas.smurfs.cert.config;

import com.iscas.smurfs.cert.interceptor.SystemCertInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    SystemCertInterceptor systemCertInterceptor() {
        return new SystemCertInterceptor();
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(systemCertInterceptor());
    }

}