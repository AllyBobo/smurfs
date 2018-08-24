package com.iscas.smurfs.dbservice.service;

import com.iscas.smurfs.dbservice.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findByCategoryType(Integer type);
}