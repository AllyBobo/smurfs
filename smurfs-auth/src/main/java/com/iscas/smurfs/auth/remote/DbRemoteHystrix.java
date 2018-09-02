package com.iscas.smurfs.auth.remote;

import com.iscas.smurfs.core.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DbRemoteHystrix implements DbRemote {
    @Override
    public String getUserByUsername(String username) {
        return "getUserByUsername  " +username+", this messge send failed ";
    }
}
