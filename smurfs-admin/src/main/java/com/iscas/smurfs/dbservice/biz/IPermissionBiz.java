package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.admin.entity.po.Permission;

import java.util.List;

public interface IPermissionBiz extends IBaseBiz<Permission> {
    boolean checkUrlPermission(String url,String method);
    List<Permission> getAllPermissions();
}
