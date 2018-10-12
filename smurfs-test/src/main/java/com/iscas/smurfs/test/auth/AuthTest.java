package com.iscas.smurfs.test.auth;

import com.iscas.smurfs.common.entity.ResponseData;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.common.utils.OkHttp3Utils;
import com.iscas.smurfs.core.entity.User;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class AuthTest {

    public void testToken(){
        String path = "http://localhost:5555/auth/token";
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest("test","123");
        String token = OkHttp3Utils.httpPost(path,JsonUtils.toJson(jwtAuthenticationRequest));
        System.out.println(token);
        String pubkey = OkHttp3Utils.httpGet("http://localhost:5555/auth/userPubKey",token);
        System.out.println(pubkey);

//        String path1 = "http://localhost:5555/foo";
//        System.out.println(OkHttp3Utils.httpGet(path1,token));

    }

    public static void main(String[] args) {
        AuthTest authTest = new AuthTest();
        authTest.testToken();

//        User user = new User();
//        user.setUsername("123");
//        user.setPassword("kjljkj");
//        System.out.println(JsonUtils.toJson(user));
    }
}
