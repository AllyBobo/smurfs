package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.common.config.KeyConfiguration;
import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.auth.entity.dto.UserLoginDto;
import com.iscas.smurfs.common.entity.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;
    @Autowired
    private KeyConfiguration keyConfiguration;


    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseData createAuthenticationToken(
            @RequestBody UserLoginDto userLoginDto) throws Exception {
        final String token = authService.login(userLoginDto);
        return ResponseData.ok(token);
    }

    @RequestMapping(value = "/userPubKey",method = RequestMethod.GET)
    public ResponseData<byte[]> getUserPublicKey(){
        return ResponseData.ok(keyConfiguration.getUserPubKey());
    }

}
