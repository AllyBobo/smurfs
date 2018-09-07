package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserBizTest {
    @Autowired
    IUserBiz userBiz;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");

        Assert.notNull(userBiz.insert(user),"insert succ");
    }

}