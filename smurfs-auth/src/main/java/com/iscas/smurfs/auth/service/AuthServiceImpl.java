package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.auth.entity.UserInfo;
import com.iscas.smurfs.auth.query.AuthQuery;

public class AuthServiceImpl implements AuthService{
    @Override
    public UserInfo auth(AuthQuery query) {
        return new UserInfo(1L);
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        return null;
    }
}
