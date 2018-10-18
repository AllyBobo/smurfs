package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.admin.entity.po.UserPermission;
import com.iscas.smurfs.dbservice.mapper.UserPermissionMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/7
 */

@Service
@Transactional
public class UserPermissionBizImpl extends BaseBizImpl<UserPermissionMapper,UserPermission> implements IUserPermissionBiz{

    @Cacheable
    @Override
    public boolean checkUserAndPermission(Integer userid, Long permissionid) {
        UserPermission userPermission = new UserPermission();
        userPermission.setPermissionid(permissionid);
        userPermission.setUserid(userid);
        return !super.mapper.select(userPermission).isEmpty();
    }
}
