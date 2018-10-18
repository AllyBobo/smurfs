package com.iscas.smurfs.auth.feign;

import org.springframework.stereotype.Component;

@Component
public class AdminFallback implements IAdminFeign {
    @Override
    public String getUserByUsername(String username) {
        return "getUserByUsername  " +username+", this messge send failed ";
    }
}
