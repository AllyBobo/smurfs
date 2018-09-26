package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.common.utils.FileUtils;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.dbservice.entity.Fund;
import com.iscas.smurfs.dbservice.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class IFundBizTest {
    @Autowired
    IFundBiz fundBiz;
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

        Fund fund = new Fund();
        fund.setDataaircraft("关联-dataaircraft");
        fund.setDatasatellite("关联-datasatellite");
        fund.setFacility("关联-facility");
        fund.setIsVip("是");
        fund.setIsBudget("否");
        fund.setType("训练费用");
        fund.setName("武器装备采购");

//        Fund fund1 = new Fund();
//        fund1.setDataaircraft("dataaircraft");
//        fund1.setDatasatellite("datasatellite");
//        fund1.setFacility("facility");
//        fund1.setIs("0");
//        fund1.setIsBudget("0");
//        fund1.setType("技术创新");
//        fund1.setName("武器装备创新项目");
        //Assert.notNull(fundBiz.insert(fund),"insert succ");
        //Assert.notNull(fundBiz.insert(fund1),"insert succ");
        System.out.println(fundBiz.selectAll().size());
       // FileUtils.writeToFile("test.txt",JsonUtils.toJson(fundBiz.selectAll()),false);

    }
}

