package com.iscas.smurfs.opera1service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(name = "DBSERVICE",fallback = DbRemoteHystrix.class)
public interface DbRemote {
    @RequestMapping(value = "db/findByCategoryType/{type}")
    public String findByCategoryType(@RequestParam(value = "type") String type);
}
