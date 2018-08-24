package com.iscas.smurfs.dbservice.service;

import com.iscas.smurfs.dbservice.entity.ProductCategory;
import com.iscas.smurfs.dbservice.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findByCategoryType(Integer type) {
        return productCategoryMapper.findByCategoryType(type);
    }
}
