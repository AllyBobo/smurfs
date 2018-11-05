package com.iscas.smurfs.admin2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class Admin2Application {

    public static void main(String[] args) {
        SpringApplication.run(Admin2Application.class, args);
    }
}