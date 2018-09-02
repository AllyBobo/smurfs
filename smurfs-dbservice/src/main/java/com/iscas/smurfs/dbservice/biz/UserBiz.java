package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.dbservice.entity.User;
import com.iscas.smurfs.dbservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * description:
 * Userbiz
 *
 * @author 123
 * @date 2018/8/31
 */

@Service
public class UserBiz extends BaseBiz<UserMapper,User>{

    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }
}
