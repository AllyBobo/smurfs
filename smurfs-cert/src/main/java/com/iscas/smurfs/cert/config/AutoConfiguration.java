package com.iscas.smurfs.cert.config;

import com.iscas.smurfs.cert.service.UserJwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/17
 */
@Configuration
@ComponentScan({"com.iscas.smurfs.cert"})
public class AutoConfiguration {

    @Bean
    UserJwtService getUserJwtService(){
        return new UserJwtService();
    }

}
