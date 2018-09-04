package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.entity.User;

public interface IUserBiz extends IBaseBiz<User> {

    User getUserByUsername(String username);
}
