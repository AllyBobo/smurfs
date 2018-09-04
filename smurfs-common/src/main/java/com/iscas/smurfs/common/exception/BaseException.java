package com.iscas.smurfs.common.exception;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class BaseException extends RuntimeException  {
    private int status = 200;


    public BaseException(String message) {
        super(message);
    }
    public BaseException(String message,int status) {
        super(message);
        this.status = status;
    }
}
