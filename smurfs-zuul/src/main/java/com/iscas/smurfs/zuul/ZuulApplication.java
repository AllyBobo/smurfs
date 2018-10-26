package com.iscas.smurfs.zuul;

//import com.iscas.smurfs.zuul.filter.PreRequestFilter;
import com.iscas.smurfs.cache.EnableSmurfsCache;
import com.iscas.smurfs.cert.EnableSmurfsCert;
import com.iscas.smurfs.common.EnableSmurfsCommon;
import com.iscas.smurfs.zuul.filter.PreRequestFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSmurfsCache
@EnableSmurfsCert
@EnableSmurfsCommon
@EnableFeignClients({"com.iscas.smurfs.zuul.feign","com.iscas.smurfs.cert.feign"})
public class ZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    public PreRequestFilter preRequestFilter(){
        return new PreRequestFilter();
    }
}

