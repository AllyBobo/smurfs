package com.iscas.smurfs.auth.runner;

import com.iscas.smurfs.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/11
 */
@Configuration
@Slf4j
public class RefreshKeyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
        try {
            refreshUserPubKey();
        }catch(Exception e){
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey(){
//        ResponseData responseData =
    }
}
