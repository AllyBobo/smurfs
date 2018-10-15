package com.iscas.smurfs.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
    private int code = 200;
    private String message = "";
    private T data;

    public static ResponseData ok(Object data) {
        return new ResponseData(data);
    }

    public static ResponseData fail() {
        return new ResponseData(null);
    }

    public static ResponseData fail(String message) {
        return new ResponseData(message);
    }

    public static ResponseData fail(String message, int code) {
        return new ResponseData(code,message);
    }

    public static ResponseData failByParam(String message) {
        return new ResponseData( ResponseCode.PARAM_ERROR_CODE.getCode(),message);
    }

    public ResponseData(T data) {
        super();
        this.data = data;
    }

    public ResponseData(String message) {
        super();
        this.message = message;
    }
    public ResponseData(int code,String message) {
        super();
        this.message = message;
        this.code = code;
    }
}
