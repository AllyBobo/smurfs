package com.iscas.smurfs.common.exception;


import com.iscas.smurfs.common.exception.BaseException;
import com.iscas.smurfs.common.constant.Constant;


public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, Constant.EX_USER_INVALID_CODE);
    }
}
