package com.iscas.smurfs.core.opera1service.remote;

import org.springframework.stereotype.Component;

@Component
public class DbRemoteHystrix implements DbRemote {
    @Override
    public String findByCategoryType(String type) {
        return "findByCategoryType  " +type+", this messge send failed ";
    }
}
