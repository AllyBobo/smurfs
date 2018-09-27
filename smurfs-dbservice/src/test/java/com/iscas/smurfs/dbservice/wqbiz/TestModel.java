package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.common.utils.excel.ExcelField;
import lombok.Data;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/27
 */
@Data
public class TestModel {
    @ExcelField(title="编号", align=2, sort=20)
    private String id;
    @ExcelField(title="名称", align=2, sort=25)
    private String name;
    @ExcelField(title="备注", align=2, sort=30)
    private String desc;
}
