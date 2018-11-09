package com.iscas.smurfs.admin2.dao.system;

import com.google.common.collect.Lists;
import com.iscas.smurfs.admin2.command.CreateTableParam;
import com.iscas.smurfs.admin2.command.SysMysqlColumns;
import com.iscas.smurfs.admin2.constants.MySqlTypeConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: lee
 * @date: 2018-11-08
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateMysqlTablesMapperTest {
    @Autowired
    CreateMysqlTablesMapper createMysqlTablesMapper;

    @Test
    public void createTable() {
        Map<String, List<Object>> tableMap = new HashMap<>();
        List<Object> list = Lists.newArrayList();

        list.add(new CreateTableParam("id",MySqlTypeConstant.INT,11,false,true));
        list.add(new CreateTableParam("name",MySqlTypeConstant.VARCHAR,255,false,false));
        list.add(new CreateTableParam("desc",MySqlTypeConstant.VARCHAR,255,false,false));

        tableMap.put("userxxx",list);
        createMysqlTablesMapper.createTable(tableMap);
    }

    @Test
    public void findTableCountByTableName() {
    }

    @Test
    public void findTableEnsembleByTableName() {
        List<SysMysqlColumns> sysMysqlColumns = createMysqlTablesMapper.findTableEnsembleByTableName("userxxx");
        System.out.println("---------"+sysMysqlColumns.size());
        sysMysqlColumns.forEach(i->System.out.println(i.toString()));

    }

    @Test
    public void addTableField() {
    }

    @Test
    public void removeTableField() {
    }

    @Test
    public void modifyTableField() {
    }

    @Test
    public void dropKeyTableField() {
    }

    @Test
    public void dropUniqueTableField() {
    }

    @Test
    public void dorpTableByName() {
    }

    @Test
    public void findTableByDbName() {
    }
}