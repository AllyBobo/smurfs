//package com.iscas.smurfs.admin2.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
///**
// * @author: lee
// * @date: 2018-11-09
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DynamicDataSourceTest {
//    @Autowired
//    DynamicDataSource dynamicDataSource;
//
//    @Test
//    public void addBean() throws ClassNotFoundException {
//        Map<String,String> map = new HashMap<>();
//        map.put("url","jdbc:mysql://127.0.0.1:3306/smurfs?useUnicode=true&characterEncoding=utf8");
//        map.put("username","root");
//        map.put("password","123");
//        map.put("driver-class-name","com.mysql.jdbc.Driver");
//        dynamicDataSource.addBean("dataSource", DruidDataSource.class,map);
//        dynamicDataSource.showAllBeans();
//    }
//
//    @Test
//    public void removeBean() {
//        dynamicDataSource.removeBean("dataSource");
//    }
//
//    @Test
//    public void showAllBeans() {
//
//        dynamicDataSource.showAllBeans();
//    }
//}