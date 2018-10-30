package com.iscas.smurfs.dbservice.biz;

import com.github.pagehelper.PageInfo;
import com.iscas.smurfs.core.admin.entity.po.User;

public interface IUserBiz extends IBaseBiz<User> {

    User getUserByUsername(String username);
    PageInfo<User> queryByPage(Integer pageNo,Integer pageSize,User user);
}
