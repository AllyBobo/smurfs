package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.dbservice.biz.UserBiz;
import com.iscas.smurfs.dbservice.entity.User;
import org.springframework.beans.BeanUtils;
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
    UserBiz userBiz;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public User validate(String username, String password) {
        User user = new User();
        user = userBiz.getUserByUsername(username);
        if (encoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
