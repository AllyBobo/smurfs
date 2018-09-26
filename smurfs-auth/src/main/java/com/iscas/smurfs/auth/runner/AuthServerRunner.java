package com.iscas.smurfs.auth.runner;

import com.iscas.smurfs.auth.config.KeyConfiguration;
import com.iscas.smurfs.core.helper.RsaKeyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/26
 */
@Configuration
public class AuthServerRunner implements CommandLineRunner {
    @Autowired
    KeyConfiguration keyConfiguration;
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    @Override
    public void run(String... args) throws Exception {
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY)&&redisTemplate.hasKey(REDIS_USER_PUB_KEY)){
            keyConfiguration.setUserPriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString()));
            keyConfiguration.setUserPubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
        }else {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey();
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
        }
    }
}
