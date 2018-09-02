package com.iscas.smurfs.core.opera1service.remote;

import com.iscas.smurfs.core.entity.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@FeignClient(name = "LOGSERVICE", fallback = LogRemoteHystrix.class)
public interface LogRemote {
    @RequestMapping(value = "log")
    public String log(@RequestBody Log log);
}
