package com.iscas.smurfs.common.exception;

import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.exception.BaseException;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, Constant.EX_USER_INVALID_CODE);
    }
}
