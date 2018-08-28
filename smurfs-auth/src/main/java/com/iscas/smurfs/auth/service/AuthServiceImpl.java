package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.auth.entity.User;
import com.iscas.smurfs.auth.query.AuthQuery;

public class AuthServiceImpl implements AuthService{
    @Override
    public User auth(AuthQuery query) {
        return new User(1L);
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        return null;
    }
}
