package com.iscas.smurfs.cert.runner;

import com.iscas.smurfs.common.config.UserConfiguration;

import com.iscas.smurfs.cert.feign.IAuthFeign;
import com.iscas.smurfs.common.entity.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/17
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {

    @Autowired
    private UserConfiguration userConfiguration;

    @Autowired
    IAuthFeign authFeign;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
        try {
            refreshUserPubKey();
        }catch(Exception e){
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
        }
    }
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey(){
        ResponseData resp = authFeign.getUserPublicKey();
        if (resp.getCode() == HttpStatus.OK.value()) {
            ResponseData<byte[]> userResponse = (ResponseData<byte[]>) resp;
            this.userConfiguration.setPubKeyByte(userResponse.getData());
        }
    }

}
