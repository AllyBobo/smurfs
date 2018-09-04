package com.iscas.smurfs.opera1service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Opera1ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Opera1ServiceApplication.class,args);
    }
}
