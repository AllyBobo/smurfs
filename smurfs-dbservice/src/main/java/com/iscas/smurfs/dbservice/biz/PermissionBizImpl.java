package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.core.entity.Permission;
import com.iscas.smurfs.dbservice.mapper.PermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/7
 */

@Service
@Transactional
public class PermissionBizImpl extends BaseBizImpl<PermissionMapper,Permission> implements IPermissionBiz {

    @Override
    public boolean checkUrlPermission(String url, String method) {
        Permission permission = new Permission();
        permission.setUri(url);
        permission.setMethod(method);
        return super.mapper.select(permission).isEmpty();
    }

    @Override
    public List<Permission> getAllPermissions() {
        return super.mapper.selectAll();
    }

}
