package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.auth.common.JWTUtils;
import com.iscas.smurfs.auth.entity.UserInfo;
import com.iscas.smurfs.auth.query.AuthQuery;
import com.iscas.smurfs.auth.service.AuthService;
import com.iscas.smurfs.common.entity.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/oauth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/token")
    public ResponseData auth(@RequestBody AuthQuery query) throws Exception {
        if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
            return ResponseData.failByParam("accessKey and secretKey not null");
        }

        UserInfo user = authService.auth(query);
        if (user == null) {
            return ResponseData.failByParam("认证失败");
        }

        JWTUtils jwt = JWTUtils.getInstance();
        return ResponseData.ok(jwt.getToken(user.getId().toString()));
    }

    @GetMapping("/token")
    public ResponseData oauth(AuthQuery query) throws Exception {
        if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
            return ResponseData.failByParam("accessKey and secretKey not null");
        }

        UserInfo user = authService.auth(query);
        if (user == null) {
            return ResponseData.failByParam("认证失败");
        }

        JWTUtils jwt = JWTUtils.getInstance();
        return ResponseData.ok(jwt.getToken(user.getId().toString()));
    }

}
