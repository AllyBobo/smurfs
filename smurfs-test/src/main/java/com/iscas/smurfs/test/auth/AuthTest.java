package com.iscas.smurfs.test.auth;

import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.common.utils.OkHttp3Utils;
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
        System.out.println(OkHttp3Utils.httpPost(path,JsonUtils.toJson(jwtAuthenticationRequest)));
    }

    public static void main(String[] args) {
        AuthTest authTest = new AuthTest();
        authTest.testToken();

    }
}
