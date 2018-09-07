package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.entity.UserPermission;

public interface IUserPermissionBiz extends IBaseBiz<UserPermission> {
    boolean checkUserAndPermission(Integer userid,Long permissionid);
}
