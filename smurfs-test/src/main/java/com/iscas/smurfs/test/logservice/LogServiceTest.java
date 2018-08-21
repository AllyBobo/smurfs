package com.iscas.smurfs.test.logservice;


import com.iscas.smurfs.common.HttpUtils;
import com.iscas.smurfs.common.JsonUtils;
import com.iscas.smurfs.core.entity.Log;

public class LogServiceTest {
    public static void main(String[] args) throws Exception {
        Log log = new Log();
        log.setLogType("test tes");
        log.setLogTitle("jkljklk");
        System.out.println(HttpUtils.doPost("http://localhost:9003/log",JsonUtils.toJson(log)));
    }
}
