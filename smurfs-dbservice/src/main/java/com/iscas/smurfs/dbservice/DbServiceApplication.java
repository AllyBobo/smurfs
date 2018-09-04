package com.iscas.smurfs.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.iscas.smurfs.dbservice.mapper")
public class DbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbServiceApplication.class, args);
    }
}