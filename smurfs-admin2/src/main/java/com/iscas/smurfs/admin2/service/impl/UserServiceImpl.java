package com.iscas.smurfs.admin2.service.impl;

import com.iscas.smurfs.admin2.model.User;
import com.iscas.smurfs.admin2.dao.UserMapper;
import com.iscas.smurfs.admin2.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yux
 * @since 2018-11-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}