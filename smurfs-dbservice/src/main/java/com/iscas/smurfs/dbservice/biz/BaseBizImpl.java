package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.dbservice.config.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 * BaseBizImpl
 *
 * @author 123
 * @date 2018/8/31
 */

public class BaseBizImpl<M extends MyMapper<T>,T> implements IBaseBiz<T>{
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(T entity){
        return mapper.insert(entity);
    }

    public int insertSelective(T entity){
     return mapper.insertSelective(entity);
    }

    public T selectByPrimaryKey(Integer categoryId){
        return mapper.selectByPrimaryKey(categoryId);
    }

    public int updateByPrimaryKeySelective(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(T record){
        return mapper.updateByPrimaryKey(record);
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }
}

