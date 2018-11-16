package com.iscas.smurfs.admin2.controller;

import com.google.common.collect.Lists;
import com.iscas.smurfs.admin2.dynamic.EnvironmentConfig;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.common.utils.OkHttp3Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: lee
 * @date: 2018-11-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableMetaControllerTest {

    @Test
    public void tableStructure() {
        String message = OkHttp3Utils.httpGet("http://localhost:8080/admin2/structure");
        System.out.println(message);
    }

    @Test
    public void submitEnvironmentConfig(){
        String path = "http://localhost:8080/admin2/submitEnvironmentConfig";
        List<EnvironmentConfig> environmentConfigs = Lists.newArrayList();
        EnvironmentConfig environmentConfig = new EnvironmentConfig();
        environmentConfig.setCode("stg");
        environmentConfig.setName("开发");
        environmentConfig.setDriverClassName("com.mysql.jdbc.Driver");
        environmentConfig.setUsername("datasong");
        environmentConfig.setPassword("iscas123");
        environmentConfig.setUrl("jdbc:mysql://172.16.10.200/datasong?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
        environmentConfigs.add(environmentConfig);

        OkHttp3Utils.httpPost(path, JsonUtils.toJson(environmentConfigs));
    }
}