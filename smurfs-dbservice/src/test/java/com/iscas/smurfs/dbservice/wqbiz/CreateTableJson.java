package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.common.utils.FileUtils;
import com.iscas.smurfs.common.utils.JsonUtils;
import com.iscas.smurfs.dbservice.entity.Base;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateTableJson {
    @Autowired
    IFundBiz fundBiz;

    @Autowired
    IUsersBiz usersBiz;
    @Autowired
    IGroupBiz groupBiz;
    @Autowired
    IDatasatelliteBiz datasatelliteBiz;
    @Autowired
    IDataaircraftBiz dataaircraftBiz;
    @Autowired
    IWqBaseBiz wqBaseBiz;
    @Autowired
    IFacilityBiz facilityBiz;
    @Test
    public void insert(){
        FileUtils.writeToFile("users.json",JsonUtils.toJson(usersBiz.selectAll()),false);
        FileUtils.writeToFile("fund.json",JsonUtils.toJson(fundBiz.selectAll()),false);
        FileUtils.writeToFile("group.json",JsonUtils.toJson(groupBiz.selectAll()),false);
        FileUtils.writeToFile("base.json",JsonUtils.toJson(wqBaseBiz.selectAll()),false);
        FileUtils.writeToFile("facility.json",JsonUtils.toJson(facilityBiz.selectAll()),false);
        FileUtils.writeToFile("datasatellite.json",JsonUtils.toJson(datasatelliteBiz.selectAll()),false);
        FileUtils.writeToFile("dataaircraft.json",JsonUtils.toJson(dataaircraftBiz.selectAll()),false);
//        Base base = new Base();
//        base.setArea(23);
//        base.setCivilianNum(980l);
//        base.setDataaircraft("关联-dataaircraft");
//        base.setDatasatellite("关联-datasatellite");
//        base.setFacility("关联-facility");
//        base.setFamilymemberNum(897l);
//        base.setMygroup("关联-group");
//        base.setName("大连基地");
//        base.setLatitude(38);
//        base.setLongitude(121);
//        base.setSoldierNum(768l);
//        wqBaseBiz.insert(base);
    }
}
