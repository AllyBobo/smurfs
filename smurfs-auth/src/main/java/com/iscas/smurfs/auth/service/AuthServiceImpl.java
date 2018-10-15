package com.iscas.smurfs.auth.service;


import com.iscas.smurfs.auth.config.KeyConfiguration;
import com.iscas.smurfs.auth.entity.AuthRequest;
import com.iscas.smurfs.auth.remote.DbRemote;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.core.entity.User;
import com.iscas.smurfs.core.exception.UserInvalidException;
import com.iscas.smurfs.core.helper.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    DbRemote userBiz;

    @Autowired
    KeyConfiguration keyConfiguration;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public String login(AuthRequest authenticationRequest) throws Exception {
        User user = validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if(user!=null){
            return JWTHelper.generateToken(user.getId().toString(),user.getUsername(),keyConfiguration.getUserPriKey(),expire);
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public User validate(String username, String password) {
        User user = new User();
        user = JsonUtils.fromJson(userBiz.getUserByUsername(username),User.class);
        if (encoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
