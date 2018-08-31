package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.auth.entity.UserInfo;

public interface IAuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
}
