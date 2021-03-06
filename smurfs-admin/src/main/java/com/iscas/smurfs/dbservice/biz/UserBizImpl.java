package com.iscas.smurfs.dbservice.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.core.admin.entity.po.User;
import com.iscas.smurfs.dbservice.mapper.UserMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description:
 * Userbiz
 *
 * @author 123
 * @date 2018/8/31
 */

@Service
@Transactional
@CacheConfig(cacheNames = "user",keyGenerator = "cacheKeyGenerator")
//@Cacheable(value = "user",keyGenerator = "cacheKeyGenerator")
public class UserBizImpl extends BaseBizImpl<UserMapper, User> implements IUserBiz{


    @Cacheable(value = "user")
    @Override
    public User getUserByUsername(String username){
        System.out.println("缓存击穿了哦");
        User user = new User();
        user.setUsername(username);
        return super.mapper.selectOne(user);
    }

    @Override
    public PageInfo<User> queryByPage(Integer pageNo, Integer pageSize, User user) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = user==null?super.mapper.selectAll():super.mapper.select(user);
        return new PageInfo<>(users);
    }

    @Override
    @CachePut
    public int insert(User user){
        String password = new BCryptPasswordEncoder(Constant.PW_ENCORDER_SALT).encode(user.getPassword());
        user.setPassword(password);
        return mapper.insert(user);
    }
}
