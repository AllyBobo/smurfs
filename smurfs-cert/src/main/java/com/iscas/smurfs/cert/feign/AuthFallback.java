package com.iscas.smurfs.cert.feign;

import com.iscas.smurfs.common.entity.dto.ResponseData;

public class AuthFallback implements IAuthFeign {
    @Override
    public ResponseData<byte[]> getUserPublicKey() {
        return null;
    }
}
