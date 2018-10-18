package com.iscas.smurfs.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DBSERVICE",fallback = AdminFallback.class)
public interface IAdminFeign {
    @RequestMapping(value = "db/user/{username}")
    public String getUserByUsername(@RequestParam(value = "username") String username);
}
