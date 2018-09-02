package com.iscas.smurfs.core.common.exception;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, 40101);
    }
}
