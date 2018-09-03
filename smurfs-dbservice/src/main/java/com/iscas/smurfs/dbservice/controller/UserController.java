package com.iscas.smurfs.dbservice.controller;

import com.iscas.smurfs.dbservice.biz.IUserBiz;
import com.iscas.smurfs.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */

@RestController
@RequestMapping("db")
public class UserController {

    @Autowired
    IUserBiz userBiz;

    @RequestMapping("user/{username}")
    @ResponseBody
    public User getUserByUsername(@PathVariable("username") String username) {
        return userBiz.getUserByUsername(username);
    }
}
