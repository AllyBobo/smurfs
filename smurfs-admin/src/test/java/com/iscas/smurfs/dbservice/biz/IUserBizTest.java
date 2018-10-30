package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.core.admin.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserBizTest {
    @Autowired
    IUserBiz userBiz;

    @Test
    public void insert(){
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("123");
//
//        Assert.notNull(userBiz.insert(user),"insert succ");

        IntStream.range(1,25).forEach(i->{userBiz.insert(new User("123","test"+i));
            System.out.println(i);});
        //IntStream.range(1,25).forEach(System.out::println);
    }

    @Test
    public void query(){
        Integer pageNo = 17;
        Integer pageSize = 3;

        //System.out.println(JsonUtils.toJson(userBiz.queryByPage(pageNo,pageSize,null)));
        userBiz.queryByPage(pageNo,pageSize,null).getList().forEach(i-> System.out.println(JsonUtils.toJson(i)));
    }
}