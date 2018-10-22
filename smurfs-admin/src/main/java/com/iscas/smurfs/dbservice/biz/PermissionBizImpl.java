package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.common.annotation.Log;
import com.iscas.smurfs.core.admin.entity.po.Permission;
import com.iscas.smurfs.dbservice.mapper.PermissionMapper;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("per")
    @Override
    public boolean checkUrlPermission(String url, String method) {
        Permission permission = new Permission();
        permission.setUri(url);
        permission.setMethod(method);
        return super.mapper.select(permission).isEmpty();
    }

    @Log
    @Cacheable("per")
    @Override
    public List<Permission> getAllPermissions() {
        return super.mapper.selectAll();
    }

}
