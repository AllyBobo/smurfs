package com.iscas.smurfs.test.auth;

import com.iscas.smurfs.test.utils.HttpClient;

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
        Map<String,String> map = new HashMap<>();
        map.put("username","test");
        map.put("password","123");
        System.out.println(HttpClient.doPost("http://localhost:8993/token",map));
//        System.out.println(HttpClient.doGet("http://localhost:5555/auth/token"));
    }

    public static void main(String[] args) {
        AuthTest authTest = new AuthTest();
        authTest.testToken();
    }
}
