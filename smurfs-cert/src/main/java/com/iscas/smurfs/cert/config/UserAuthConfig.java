package com.iscas.smurfs.cert.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/23
 */
@Data
public class UserAuthConfig {
    @Value("${auth.user.token-header}")
    private String tokenHeader;

    private byte[] pubKeyByte;
}
