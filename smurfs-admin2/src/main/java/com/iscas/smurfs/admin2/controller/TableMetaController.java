package com.iscas.smurfs.admin2.controller;

import com.google.common.collect.Lists;
import com.iscas.smurfs.admin2.command.SysMysqlColumns;
import com.iscas.smurfs.admin2.dao.system.CreateMysqlTablesMapper;
import com.iscas.smurfs.common.entity.dto.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
