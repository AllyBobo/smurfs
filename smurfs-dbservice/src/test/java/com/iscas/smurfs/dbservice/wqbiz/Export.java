package com.iscas.smurfs.dbservice.wqbiz;

import com.google.common.collect.Lists;
import com.iscas.smurfs.common.utils.excel.ExportExcel;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/27
 */
public class Export {

    public static void main(String[] args) throws Exception {
        List<TestModel> testModels = Lists.newArrayList();
        for (int i=0; i<10; i++){
            TestModel testModel = new TestModel();
            testModel.setId(Integer.toString(i));
            testModel.setName("name"+i);
            testModel.setDesc("desc"+i);
            testModels.add(testModel);
        }
        new ExportExcel("用户数据", TestModel.class).setDataList(testModels).writeFile("C:\\Users\\123\\Documents\\toLishuang\\export.xlsx").dispose();
    }
}
