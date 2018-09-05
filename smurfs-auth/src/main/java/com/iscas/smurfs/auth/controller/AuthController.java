package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.common.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseData createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        final String token = authService.login(authenticationRequest);
        return ResponseData.ok(token);
    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseData test(
            ) throws Exception {
        System.out.println("-------------");
        return ResponseData.ok("test");
    }


}
