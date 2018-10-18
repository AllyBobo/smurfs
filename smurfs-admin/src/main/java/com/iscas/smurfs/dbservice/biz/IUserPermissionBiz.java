package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.admin.entity.po.UserPermission;

public interface IUserPermissionBiz extends IBaseBiz<UserPermission> {
    boolean checkUserAndPermission(Integer userid,Long permissionid);
}
