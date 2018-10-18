package com.iscas.smurfs.cert.feign;

import com.iscas.smurfs.common.entity.ResponseData;

public class AuthFallback implements IAuthFeign {
    @Override
    public ResponseData<byte[]> getUserPublicKey() {
        return null;
    }
}
