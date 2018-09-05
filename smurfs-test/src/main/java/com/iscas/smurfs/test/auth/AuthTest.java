package com.iscas.smurfs.test.auth;

import com.iscas.smurfs.common.utils.JsonUtils;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/2
 */
public class AuthTest {

    public void testToken(){

//
//       // System.out.println(HttpClient.doPost("http://localhost:5555/auth/token",map));
//  //      System.out.println(HttpClient.doGet("http://localhost:5555/auth/test"));

        String path = "http://localhost:5555/auth/token";

        // 2 创建okhttpclient对象
        OkHttpClient client = new OkHttpClient();
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest("test","123");
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        //RequestBody body = new FormBody.Builder().add("username", "test").add("password", "123").build();
        RequestBody body = RequestBody.create(JSON, JsonUtils.toJson(jwtAuthenticationRequest));
        // 3 创建请求方式
        Request request = new Request.Builder().url(path).post(body).build();

        // 4 执行请求操作
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String string = response.body().string();
                System.out.println(string);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AuthTest authTest = new AuthTest();
        authTest.testToken();
    }
}
