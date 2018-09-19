package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.auth.remote.DbRemote;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.common.utils.RSAUtils;
import com.iscas.smurfs.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */

@Service
public class PermissionImpl implements IPermission {

    @Autowired
    DbRemote userBiz;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public User validate(String username, String password) {
        User user = new User();
        user = JsonUtils.fromJson(userBiz.getUserByUsername(username),User.class);
        if (encoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserFromToken(String token,String pubKeyPath) {
        String pubKey = RSAUtils.private_exponent;

        return null;
    }

}
