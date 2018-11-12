package com.iscas.smurfs.admin2.controller;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.google.common.collect.Lists;
import com.iscas.smurfs.admin2.command.SysMysqlColumns;
import com.iscas.smurfs.admin2.dao.system.CreateMysqlTablesMapper;
import com.iscas.smurfs.admin2.dynamic.DynamicDataSourceRegisterUtil;
import com.iscas.smurfs.admin2.dynamic.EnvironmentConfig;
import com.iscas.smurfs.common.entity.dto.ResponseData;
import com.iscas.smurfs.common.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author: lee
 * @date: 2018-11-08
 */

@RestController
public class TableMetaController {

    @Autowired
    CreateMysqlTablesMapper createMysqlTablesMapper;
    @Value("${database.name}")
    private String dbName;

    @ApiOperation(value = "无", notes = "获取表结构",produces = "application/json")
    @GetMapping(value = "/structure")
    public ResponseData tableStructure(){
        List<String> list = createMysqlTablesMapper.findTableByDbName(dbName);
        List<Map<String,List<SysMysqlColumns>>> mapList = Lists.newArrayList();
        list.forEach(i->{
            Map<String,List<SysMysqlColumns>> stringListMap = new HashMap<>();
            stringListMap.put(i,createMysqlTablesMapper.findTableEnsembleByTableName(i));
            mapList.add(stringListMap);
        });
        return ResponseData.ok(mapList);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value="submitEnvironmentConfig")
    public ResponseData submitEnvironmentConfig(@RequestBody List<EnvironmentConfig> environmentConfigs) throws Exception{
        if(environmentConfigs==null||environmentConfigs.size()==0){
            return ResponseData.fail("没有数据！");
        }
//参数校验
        String codes = " ";
        String names = " ";
//生成prop
        Properties properties=new Properties();
        for (EnvironmentConfig e:environmentConfigs){
            if(StringUtils.isEmpty(e.getCode())||
                    StringUtils.isEmpty(e.getName())||
                    StringUtils.isEmpty(e.getDriverClassName())||
                    StringUtils.isEmpty(e.getPassword())||
                    StringUtils.isEmpty(e.getUsername())||
                    StringUtils.isEmpty(e.getUrl())){
                return ResponseData.fail("所有参数不能为空！");
            }
            codes=codes+","+e.getCode().trim();
            names=names+","+e.getName().trim();
            properties.setProperty(e.getCode().trim()+ DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_SPLIT+DynamicDataSourceRegisterUtil.DRUID_DATASOURCE_PARAM_PREF+DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_PRPO_KEY_DRIVER_CLASS_NAME,e.getDriverClassName());
            properties.setProperty(e.getCode().trim()+DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_SPLIT+DynamicDataSourceRegisterUtil.DRUID_DATASOURCE_PARAM_PREF+ DruidDataSourceFactory.PROP_URL,e.getUrl());
            properties.setProperty(e.getCode().trim()+DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_SPLIT+DynamicDataSourceRegisterUtil.DRUID_DATASOURCE_PARAM_PREF+DruidDataSourceFactory.PROP_USERNAME,e.getUsername());
            properties.setProperty(e.getCode().trim()+DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_SPLIT+DynamicDataSourceRegisterUtil.DRUID_DATASOURCE_PARAM_PREF+DruidDataSourceFactory.PROP_PASSWORD,e.getPassword());
        }
        codes=codes.substring(1);
        names=names.substring(1);
        properties.setProperty(DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_PREF+"keys",codes);
        properties.setProperty(DynamicDataSourceRegisterUtil.DATASOURCE_PARAM_PREF+"names",names);
        DynamicDataSourceRegisterUtil.refreshDataSoureProperties(properties);
        return ResponseData.ok("succ");
    }
}
