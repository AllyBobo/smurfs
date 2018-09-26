package com.iscas.smurfs.zuul.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DBSERVICE",fallback = DbRemoteHystrix.class)
@Repository
public interface DbRemote {

    @RequestMapping(value = "db/checkUserAndPermission/{userid}/{permissionid}")
    public Boolean checkUserAndPermission(@RequestParam(value = "userid") Integer userid,@RequestParam(value = "permissionid") Long permissionid);

    @RequestMapping(value = "db/checkUrlPermission/{url}/{method}")
    public String checkUrlPermission(@RequestParam(value = "url") String url,@RequestParam(value = "method") String method);

    @RequestMapping(value = "db/getAllPermissions")
    public String getAllPermissions();
}
