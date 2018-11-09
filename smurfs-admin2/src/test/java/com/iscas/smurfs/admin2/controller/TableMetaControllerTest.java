package com.iscas.smurfs.admin2.controller;

import com.iscas.smurfs.common.utils.OkHttp3Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}