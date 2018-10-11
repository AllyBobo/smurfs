package com.iscas.smurfs.zuul;

import com.iscas.smurfs.zuul.filter.PreRequestFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
@EnableFeignClients({"com.iscas.smurfs.zuul.remote"})
public class ZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    public PreRequestFilter preRequestFilter(){
        return new PreRequestFilter();
    }
}

