package com.iscas.smurfs.auth.service;


import com.iscas.smurfs.auth.config.KeyConfiguration;
import com.iscas.smurfs.auth.entity.AuthRequest;
import com.iscas.smurfs.core.entity.User;
import com.iscas.smurfs.core.exception.UserInvalidException;
import com.iscas.smurfs.core.helper.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Value("${jwt.expire}")
    private int expire;
    @Autowired
    IPermission permission;
    @Autowired
    KeyConfiguration keyConfiguration;
    @Override
    public String login(AuthRequest authenticationRequest) throws Exception {
        User user = permission.validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if(user!=null){
            return JWTHelper.generateToken(user.getId().toString(),user.getUsername(),keyConfiguration.getUserPriKey(),expire);
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

}
