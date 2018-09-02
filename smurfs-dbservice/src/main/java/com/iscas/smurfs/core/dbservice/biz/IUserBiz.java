package com.iscas.smurfs.core.dbservice.biz;

import com.iscas.smurfs.core.entity.User;

public interface IUserBiz extends IBaseBiz {

    User getUserByUsername(String username);
}
