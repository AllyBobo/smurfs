package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IGroupBizTest {
    @Autowired
    IGroupBiz groupBiz;
    @Test
    public void insert(){
//        Group group = new Group();
//        group.setBaseId("10000");
//        group.setBugdet(200000);
//        group.setUserNum(100000);
//        group.setName("东部战区");
//        group.setParentId("10000");
//        group.setDataaircraft("关联");
//        group.setDatasatellite("关联");
//        group.setUser("关联");

        Group group = new Group();
        group.setBaseId("10000");
        group.setBugdet(20000);
        group.setUserNum(50000);
        group.setName("上海基地");
        group.setParentId("10000");
        group.setDataaircraft("关联");
        group.setDatasatellite("关联");
        group.setUser("关联");

        Group group1 = new Group();
        group1.setBaseId("10000");
        group1.setBugdet(2000);
        group1.setUserNum(8000);
        group1.setName("85旅");
        group1.setParentId("10000");
        group1.setDataaircraft("关联");
        group1.setDatasatellite("关联");
        group1.setUser("关联");

        Group group2 = new Group();
        group2.setBaseId("10000");
        group2.setBugdet(800);
        group2.setUserNum(500);
        group2.setName("航空大队2");
        group2.setParentId("10000");
        group2.setDataaircraft("关联");
        group2.setDatasatellite("关联");
        group2.setUser("关联");

        Group group3 = new Group();
        group3.setBaseId("10000");
        group3.setBugdet(200);
        group3.setUserNum(106);
        group3.setName("航空中队3");
        group3.setParentId("10000");
        group3.setDataaircraft("关联");
        group3.setDatasatellite("关联");
        group3.setUser("关联");
        Assert.notNull(groupBiz.insert(group),"insert succ");
        Assert.notNull(groupBiz.insert(group1),"insert succ");
        Assert.notNull(groupBiz.insert(group2),"insert succ");
        Assert.notNull(groupBiz.insert(group3),"insert succ");
    }
}
