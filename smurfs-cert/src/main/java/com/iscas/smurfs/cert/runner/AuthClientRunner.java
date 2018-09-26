//package com.iscas.smurfs.cert.runner;
//
//import com.iscas.smurfs.cert.jwt.UserAuthUtil;
//import com.iscas.smurfs.cert.remote.ServiceAuthFeign;
//import com.iscas.smurfs.common.entity.ResponseData;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.scheduling.annotation.Scheduled;
//
///**
// * description:
// *
// * @author lee
// * @date 2018/9/17
// */
//@Configuration
//@Slf4j
//public class AuthClientRunner implements CommandLineRunner {
//
//    @Autowired
//    private UserAuthUtil userAuthConfig;
//    @Autowired
//    private ServiceAuthFeign serviceAuthFeign;
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("初始化加载用户pubKey");
//        try {
//            refreshUserPubKey();
//        }catch(Exception e){
//            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
//        }
//        log.info("初始化加载客户pubKey");
//        try {
//            refreshServicePubKey();
//        }catch(Exception e){
//            log.error("初始化加载客户pubKey失败,1分钟后自动重试!",e);
//        }
//    }
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void refreshUserPubKey(){
//        ResponseData resp = serviceAuthFeign.getUserPublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
//        if (resp.getStatus() == HttpStatus.OK.value()) {
//            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
//            this.userAuthConfig.setPubKeyByte(userResponse.getData());
//        }
//    }
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void refreshServicePubKey(){
//        BaseResponse resp = serviceAuthFeign.getServicePublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
//        if (resp.getStatus() == HttpStatus.OK.value()) {
//            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
//            this.serviceAuthConfig.setPubKeyByte(userResponse.getData());
//        }
//    }
//
//}
