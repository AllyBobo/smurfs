package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.AuthRequest;
import com.iscas.smurfs.core.entity.User;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/15
 */
public interface IAuthService {

    String login(AuthRequest authenticationRequest) throws Exception;
    User validate(String username, String password);
}
