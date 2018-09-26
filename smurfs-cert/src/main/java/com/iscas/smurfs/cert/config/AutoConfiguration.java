package com.iscas.smurfs.cert.config;

import com.iscas.smurfs.cert.jwt.UserAuthUtil;
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
    UserAuthUtil getUserAuthConfig(){
        return new UserAuthUtil();
    }

}
