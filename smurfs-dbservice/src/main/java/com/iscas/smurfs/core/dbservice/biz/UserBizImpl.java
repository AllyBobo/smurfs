package com.iscas.smurfs.core.dbservice.biz;

import com.iscas.smurfs.core.entity.User;
import com.iscas.smurfs.core.dbservice.mapper.UserMapper;
import org.springframework.stereotype.Repository;
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
}
