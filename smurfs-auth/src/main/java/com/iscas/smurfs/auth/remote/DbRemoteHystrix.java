package com.iscas.smurfs.auth.remote;

import org.springframework.stereotype.Component;

@Component
public class DbRemoteHystrix implements DbRemote {
    @Override
    public String getUserByUsername(String username) {
        return "getUserByUsername  " +username+", this messge send failed ";
    }
}
