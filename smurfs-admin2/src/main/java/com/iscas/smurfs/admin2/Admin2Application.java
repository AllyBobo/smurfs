package com.iscas.smurfs.admin2;


import com.iscas.smurfs.admin2.config.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.iscas.smurfs.admin2.dao")
public class Admin2Application {

    public static void main(String[] args) {
        SpringApplication.run(Admin2Application.class, args);
//        ApplicationContext app = SpringApplication.run(Admin2Application.class, args);
//        SpringUtils.setApplicationContext(app);
    }
}