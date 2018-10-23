package com.iscas.smurfs.dbservice;

//import com.iscas.smurfs.cache.EnableSmurfsCommon;
import com.iscas.smurfs.cache.EnableSmurfsCache;
import com.iscas.smurfs.common.EnableSmurfsCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSmurfsCache
@EnableSmurfsCommon
@EnableEurekaClient
@MapperScan("com.iscas.smurfs.dbservice.mapper")
public class DbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbServiceApplication.class, args);
    }
}