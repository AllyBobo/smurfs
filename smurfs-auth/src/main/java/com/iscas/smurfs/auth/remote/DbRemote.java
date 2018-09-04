package com.iscas.smurfs.auth.remote;

import com.iscas.smurfs.core.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="DBSERVICE",url = "http://localhost:8999",fallback = DbRemoteHystrix.class)
@FeignClient(name="DBSERVICE",fallback = DbRemoteHystrix.class)
public interface DbRemote {
    @RequestMapping(value = "db/user/{username}")
    public String getUserByUsername(@RequestParam(value = "username") String username);
}
