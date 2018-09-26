package com.iscas.smurfs.core.entity;

import com.iscas.smurfs.common.entity.ResponseData;
import com.iscas.smurfs.core.constant.Constant;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/26
 */
public class TokenForbiddenResponse extends ResponseData {
    public TokenForbiddenResponse(String message) {
        super(Constant.TOKEN_FORBIDDEN_CODE, message);
    }
}