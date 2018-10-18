package com.iscas.smurfs.common.entity;

import com.iscas.smurfs.common.constant.Constant;

public class TokenForbiddenResponse extends ResponseData{
    public TokenForbiddenResponse(String message) {
        super(Constant.TOKEN_FORBIDDEN_CODE, message);
    }
}
