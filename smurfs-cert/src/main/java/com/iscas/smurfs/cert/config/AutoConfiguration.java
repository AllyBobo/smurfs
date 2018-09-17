package com.iscas.smurfs.cert.config;

import com.iscas.smurfs.cert.jwt.UserAuthConfig;
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
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }

}
