//package com.iscas.smurfs.cert.remote;
//
//import com.iscas.smurfs.common.entity.ResponseData;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * description:
// *
// * @author lee
// * @date 2018/9/17
// */
//@FeignClient(value = "${auth.serviceId}",configuration = {})
//public interface ServiceAuthFeign {
//    @RequestMapping(value = "/client/userPubKey",method = RequestMethod.POST)
//    public ResponseData<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
//
//}
