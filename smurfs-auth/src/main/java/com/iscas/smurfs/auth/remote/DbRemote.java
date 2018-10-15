package com.iscas.smurfs.auth.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DBSERVICE",fallback = DbRemoteHystrix.class)
public interface DbRemote {
    @RequestMapping(value = "db/user/{username}")
    public String getUserByUsername(@RequestParam(value = "username") String username);
}
