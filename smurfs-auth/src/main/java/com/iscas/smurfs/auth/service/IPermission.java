package com.iscas.smurfs.auth.service;


import com.iscas.smurfs.core.entity.User;

public interface IPermission {
    User validate(String username, String password);
}
