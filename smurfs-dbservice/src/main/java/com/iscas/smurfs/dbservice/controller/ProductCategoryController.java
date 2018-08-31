package com.iscas.smurfs.dbservice.controller;

import com.iscas.smurfs.dbservice.entity.ProductCategory;
import com.iscas.smurfs.dbservice.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @RequestMapping("db/findByCategoryType/{id}")
    @ResponseBody
    public ProductCategory getCategory(@PathVariable("id") Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }
}