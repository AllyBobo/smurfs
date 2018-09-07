package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.AuthRequest;

public interface IAuthService {
    String login(AuthRequest authenticationRequest) throws Exception;
}
