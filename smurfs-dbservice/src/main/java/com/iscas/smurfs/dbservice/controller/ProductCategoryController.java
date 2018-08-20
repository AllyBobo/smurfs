package com.iscas.smurfs.dbservice.controller;

import com.iscas.smurfs.dbservice.entity.ProductCategory;
import com.iscas.smurfs.dbservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService categoryService;

    @RequestMapping("db/findByCategoryType/{type}")
    @ResponseBody
    public List<ProductCategory> getCategory(@PathVariable("type") Integer type) {
        return categoryService.findByCategoryType(type);
    }
}