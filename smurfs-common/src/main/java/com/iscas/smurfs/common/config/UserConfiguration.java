package com.iscas.smurfs.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/23
 */
@Data
@Configuration
public class UserConfiguration {
    @Value("${auth.user.token-header}")
    private String tokenHeader;

    private byte[] pubKeyByte;
}
