package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.common.JWTUtils;
import com.iscas.smurfs.auth.entity.JwtAuthenticationRequest;
import com.iscas.smurfs.common.exception.UserInvalidException;
import com.iscas.smurfs.dbservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class AuthServiceImpl implements IAuthService {
    @Autowired
    IPermission permission;
    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        User user = permission.validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if(user!=null){
            JWTUtils jwt = JWTUtils.getInstance();
            return jwt.getToken(user.getId().toString());
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

}