package com.iscas.smurfs.cert.remote;

import com.iscas.smurfs.common.entity.ResponseData;

public class AuthRemoteHystrix implements AuthRemote {
    @Override
    public ResponseData<byte[]> getUserPublicKey() {
        return null;
    }
}
