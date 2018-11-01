package com.iscas.smurfs.dbservice.controller;

import com.iscas.smurfs.core.admin.entity.po.Permission;
import com.iscas.smurfs.dbservice.biz.IPermissionBiz;
import com.iscas.smurfs.dbservice.biz.IUserBiz;
import com.iscas.smurfs.core.admin.entity.po.User;
import com.iscas.smurfs.dbservice.biz.IUserPermissionBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */

@RestController
@Api(description="用户管理模块")
public class UserController {

    @Autowired
    IUserBiz userBiz;
    @Autowired
    IUserPermissionBiz userPermissionBiz;
    @Autowired
    IPermissionBiz permissionBiz;

    @ApiOperation(value="用户名", notes="通过用户名获取用户信息",produces = "application/json")
    @GetMapping("user/{username}")
    @ResponseBody
    public User getUserByUsername(@PathVariable("username") String username) {
        return userBiz.getUserByUsername(username);
    }

    @GetMapping("checkUserAndPermission/{userid}/{permissionid}")
    @ResponseBody
    public Boolean checkUserAndPermission(@PathVariable("userid") Integer userid,@PathVariable("permissionid") Long permissionid){
        return  userPermissionBiz.checkUserAndPermission(userid,permissionid);
    }

    @GetMapping("checkUrlPermission/{url}/{method}")
    @ResponseBody
    public Boolean checkUrlPermission(@PathVariable("url")String url,@PathVariable("method")String method){
        return permissionBiz.checkUrlPermission(url,method);
    }

    @GetMapping("getAllPermissions")
    @ResponseBody
    public List<Permission> getAllPermissions(){
        return  permissionBiz.getAllPermissions();
    }

}
