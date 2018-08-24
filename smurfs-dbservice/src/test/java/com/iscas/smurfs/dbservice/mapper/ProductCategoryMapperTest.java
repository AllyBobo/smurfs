package com.iscas.smurfs.dbservice.mapper;


import com.iscas.smurfs.dbservice.entity.ProductCategory;
import com.iscas.smurfs.dbservice.mapper.ProductCategoryMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap();
        map.put("categoryName", "我的最爱");
        map.put("categoryType", 20);
        int insertResult = productCategoryMapper.insertByMap(map);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我讨厌的");
        productCategory.setCategoryType(17);
        int insertResult = productCategoryMapper.insertByObject(productCategory);
    }

    @Test
    public void findByCategoryType() {
        List<ProductCategory> productCategory = productCategoryMapper.findByCategoryType(17);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void updateByCategoryType() {
    }

    @Test
    public void updateByObject() {
    }

    @Test
    public void deleteByCategoryType() {
        int deleteResult = productCategoryMapper.deleteByCategoryType(20);
    }
}