package com.iscas.smurfs.dbservice.excel;

import com.iscas.smurfs.common.utils.excel.ExportExcel;
import com.iscas.smurfs.common.utils.excel.ImportExcel;
import com.iscas.smurfs.core.admin.entity.po.User;
import com.iscas.smurfs.dbservice.biz.IUserBiz;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author: lee
 * @date: 2018-11-07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelTest {
    @Autowired
    IUserBiz userBiz;

    @Test
    public void export() throws IOException {
        ExportExcel exportExcel = new ExportExcel("用户表", User.class);
        List<User> users = userBiz.selectAll();
        exportExcel.setDataList(users);
        exportExcel.writeFile("C:\\Users\\lee\\Desktop\\单位画像\\export.xlsx");
    }

    @Test
    public void inport() throws IOException, InvalidFormatException, IllegalAccessException, InstantiationException {
        //headerNum从0开始
        ImportExcel ei = new ImportExcel("C:\\Users\\lee\\Desktop\\单位画像\\export.xlsx", 1);
        //ImportExcel ei = new ImportExcel("C:/Users/lee/Desktop/单位画像/清华大学专利1-1000.xlsx", 0);
        List<User> users = ei.getDataList(User.class,null);
        System.out.println("==========");
        users.forEach(i-> System.out.println(i.toString()));
    }
}
