package com.iscas.smurfs.cert.feign;

import com.iscas.smurfs.common.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "AUTHSERVICE",fallback = AuthFallback.class)
public interface IAuthFeign {
    @RequestMapping(value = "/userPubKey",method = RequestMethod.GET)
    public ResponseData<byte[]> getUserPublicKey();

}
