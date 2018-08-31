package com.iscas.smurfs.auth.service;

import com.iscas.smurfs.dbservice.entity.User;

public interface IPermission {
    User validate(String username, String password);
}
