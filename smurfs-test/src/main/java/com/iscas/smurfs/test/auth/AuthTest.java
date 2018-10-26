package com.iscas.smurfs.test.auth;

import com.iscas.smurfs.common.entity.dto.ResponseData;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.common.utils.OkHttp3Utils;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class AuthTest {

    public void testToken(){
        String path = "http://localhost:5555/auth/login";
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest("test","123");
        String response = OkHttp3Utils.httpPost(path,JsonUtils.toJson(jwtAuthenticationRequest));
        ResponseData responseData = JsonUtils.fromJson(response,ResponseData.class);
        String token = (String)responseData.getData();
        System.out.println(token);
        String pubkey = OkHttp3Utils.httpGet("http://localhost:5555/auth/userPubKey",token);
        System.out.println(pubkey);
        String message = OkHttp3Utils.httpGet("http://localhost:5555/auth/logout");
        System.out.println(message);
        String pubkey1 = OkHttp3Utils.httpGet("http://localhost:5555/auth/userPubKey");
        System.out.println(pubkey1);

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
