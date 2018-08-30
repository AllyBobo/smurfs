package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.auth.entity.UserInfo;
import com.iscas.smurfs.auth.query.AuthQuery;

public interface AuthService {
    UserInfo auth(AuthQuery query);
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
}
