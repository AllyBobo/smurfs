package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.core.common.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ResponseData createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        final String token = authService.login(authenticationRequest);
        return ResponseData.ok(token);
    }




}
