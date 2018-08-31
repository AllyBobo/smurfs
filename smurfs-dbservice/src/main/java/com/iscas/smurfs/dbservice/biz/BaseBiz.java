package com.iscas.smurfs.dbservice.biz;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * description:
 * BaseBiz
 *
 * @author 123
 * @date 2018/8/31
 */
public class BaseBiz<M extends Mapper<T>,T> {
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(T entity){
        mapper.insert(entity);
    }

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}

