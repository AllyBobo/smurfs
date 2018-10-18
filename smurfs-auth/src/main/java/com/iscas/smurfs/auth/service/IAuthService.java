package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.entity.dto.UserLoginDto;
import com.iscas.smurfs.core.admin.entity.po.User;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/15
 */
public interface IAuthService {

    String login(UserLoginDto authenticationRequest) throws Exception;
    User validate(String username, String password);
}
