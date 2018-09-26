package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.IUserBiz;
import com.iscas.smurfs.dbservice.entity.Base;
import com.iscas.smurfs.dbservice.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUsersBizTest {
    @Autowired
    IUsersBiz usersBiz;

    @Test
    public void insert(){

//        Users user = new Users();
//        user.setAge(34);
//        user.setArmyAge(15);
//        user.setFlyHour(2000l);
//        user.setGender("男");
//        user.setGroupId("10000");
//        user.setPosition("中校飞行员");
//        user.setJiguan("广东省深圳市");
//        user.setType("军官");
//        user.setRank("中校");
//        user.setName("张三");

        Users user = new Users();
        user.setAge(22);
        user.setArmyAge(3);
        user.setFlyHour(100l);
        user.setGender("男");
        user.setGroupId("10000");
        user.setPosition("飞行员");
        user.setJiguan("广东省东莞市");
        user.setType("士兵");
        user.setRank("上士");
        user.setName("李四");

        Users user1 = new Users();
        user1.setAge(25);
        user1.setArmyAge(6);
        user1.setFlyHour(100l);
        user1.setGender("男");
        user1.setGroupId("10000");
        user1.setPosition("试飞员");
        user1.setJiguan("广东省广州市");
        user1.setType("士兵");
        user1.setRank("上士");
        user1.setName("赵武");


//        Assert.notNull(usersBiz.insert(user),"insert succ");
//        Assert.notNull(usersBiz.insert(user1),"insert succ");
        List<Users> usersList = usersBiz.selectAll();
        System.out.println(usersList.size());




    }

}