package com.iscas.smurfs.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  RedisTemplate redisCacheTemplate;

    @Test
    public void set(){
//        myBean.getTemplate().opsForValue().set("test:set","testValue1");
        System.out.println(stringRedisTemplate.opsForValue().get("test:set"));

        User user = new User(1,"username");
        redisCacheTemplate.opsForValue().set("user",user);

        User getUser = (User) redisCacheTemplate.opsForValue().get("user");
        System.out.println(getUser.getUserName());
    }

}

class User implements Serializable {
    private Integer userId;
    private String userName;

    public User(){    }

    public User(Integer userId,String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}