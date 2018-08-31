package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.auth.common.JWTUtils;
import com.iscas.smurfs.auth.entity.UserInfo;
import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.common.entity.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;



}
