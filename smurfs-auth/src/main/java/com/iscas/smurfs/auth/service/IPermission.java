package com.iscas.smurfs.auth.service;

public interface IPermission {
    UserInfo validate(String username,String password);
}
