package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;

public interface IAuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
}
