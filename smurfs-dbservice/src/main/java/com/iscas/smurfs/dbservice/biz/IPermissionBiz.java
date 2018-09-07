package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.entity.Permission;

import java.util.List;

public interface IPermissionBiz extends IBaseBiz<Permission> {
    boolean checkUrlPermission(String url,String method);
    List<Permission> getAllPermissions();
}
