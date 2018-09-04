package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.core.entity.User;
import com.iscas.smurfs.dbservice.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 * Userbiz
 *
 * @author 123
 * @date 2018/8/31
 */

@Service
@Transactional
public class UserBizImpl extends BaseBizImpl<UserMapper, User> implements IUserBiz{

    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return super.mapper.selectOne(user);
    }

    public int insert(User user){
        String password = new BCryptPasswordEncoder(Constant.PW_ENCORDER_SALT).encode(user.getPassword());
        user.setPassword(password);
        return mapper.insert(user);
    }
}
