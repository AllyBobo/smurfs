package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.auth.config.KeyConfiguration;
import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.auth.entity.AuthRequest;
import com.iscas.smurfs.common.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;
    @Autowired
    private KeyConfiguration keyConfiguration;

    @Value("${foo}")
    String foo;

    @RequestMapping("/foo")
    public String hi(){
        return foo;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseData createAuthenticationToken(
            @RequestBody AuthRequest authenticationRequest) throws Exception {
        final String token = authService.login(authenticationRequest);
        return ResponseData.ok(token);
    }
    @RequestMapping(value = "/userPubKey",method = RequestMethod.GET)
    public ResponseData<byte[]> getUserPublicKey(){
        return ResponseData.ok(keyConfiguration.getUserPubKey());
    }



    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseData test(
            ) throws Exception {
        System.out.println("-------------");
        return ResponseData.ok("test");
    }


}
