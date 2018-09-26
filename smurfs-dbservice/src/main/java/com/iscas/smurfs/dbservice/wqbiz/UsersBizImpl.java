package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.core.entity.User;
import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.biz.IUserBiz;
import com.iscas.smurfs.dbservice.entity.Users;
import com.iscas.smurfs.dbservice.mapper.UserMapper;
import com.iscas.smurfs.dbservice.mapper.UsersMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
public class UsersBizImpl extends BaseBizImpl<UsersMapper, Users> implements IUsersBiz{


}
