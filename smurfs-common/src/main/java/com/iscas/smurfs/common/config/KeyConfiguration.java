package com.iscas.smurfs.common.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/26
 */

@Configuration
@Data
public class KeyConfiguration {
    private byte[] userPubKey;
    private byte[] userPriKey;
}
