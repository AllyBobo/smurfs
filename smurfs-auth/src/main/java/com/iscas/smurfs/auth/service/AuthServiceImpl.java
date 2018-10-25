package com.iscas.smurfs.auth.service;


import com.iscas.smurfs.common.config.KeyConfiguration;
import com.iscas.smurfs.auth.entity.dto.UserLoginDto;
import com.iscas.smurfs.auth.feign.IAdminFeign;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.core.admin.entity.po.User;
import com.iscas.smurfs.common.exception.UserInvalidException;
import com.iscas.smurfs.common.utils.JwtHelper;
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
    IAdminFeign adminFeign;

    @Autowired
    KeyConfiguration keyConfiguration;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public String login(UserLoginDto authenticationRequest) throws Exception {
        User user = validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if(user!=null){
            return JwtHelper.generateToken(user.getId().toString(),user.getUsername(),keyConfiguration.getUserPriKey(),expire);
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public User validate(String username, String password) {
        User user = new User();
        user = JsonUtils.fromJson(adminFeign.getUserByUsername(username),User.class);
        if (encoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
