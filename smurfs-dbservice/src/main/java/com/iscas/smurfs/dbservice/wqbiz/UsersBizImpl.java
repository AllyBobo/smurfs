package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.entity.Users;
import com.iscas.smurfs.dbservice.mapper.UsersMapper;
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
