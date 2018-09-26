package com.iscas.smurfs.cert.remote;

import com.iscas.smurfs.common.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${AUTHSERVICE}",configuration = {})
public interface AuthRemote {
    @RequestMapping(value = "/auth/userPubKey",method = RequestMethod.GET)
    public ResponseData<byte[]> getUserPublicKey();

}
