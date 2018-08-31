package com.iscas.smurfs.dbservice.mapper;

import com.iscas.smurfs.dbservice.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}