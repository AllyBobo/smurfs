package com.iscas.smurfs.dbservice.biz;

import com.iscas.smurfs.dbservice.config.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public int deleteByPrimaryKey(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T entity){
        return mapper.insert(entity);
    }

    @Override
    public int insertSelective(T entity){
     return mapper.insertSelective(entity);
    }

    @Override
    public T selectByPrimaryKey(Integer categoryId){
        return mapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record){
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public List<T> selectAll(){return  mapper.selectAll();}

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}

