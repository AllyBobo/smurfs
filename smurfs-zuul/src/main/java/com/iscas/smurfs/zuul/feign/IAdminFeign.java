package com.iscas.smurfs.zuul.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DBSERVICE",fallback = AdminFallback.class)
public interface IAdminFeign {

    @RequestMapping(value = "db/checkUserAndPermission/{userid}/{permissionid}")
    public Boolean checkUserAndPermission(@RequestParam(value = "userid") Integer userid,@RequestParam(value = "permissionid") Long permissionid);

    @RequestMapping(value = "db/checkUrlPermission/{url}/{method}")
    public String checkUrlPermission(@RequestParam(value = "url") String url,@RequestParam(value = "method") String method);

    @RequestMapping(value = "db/getAllPermissions")
    public String getAllPermissions();
}
