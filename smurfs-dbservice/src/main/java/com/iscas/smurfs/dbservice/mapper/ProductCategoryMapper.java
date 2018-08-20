package com.iscas.smurfs.dbservice.mapper;

import com.iscas.smurfs.dbservice.entity.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository//这个注解没什么用，只是为了去掉autowire的红色报错
@Mapper
public interface ProductCategoryMapper {
    /**
     * 以map的方式插入
     *
     * @param map
     * @return
     */
    @Insert("insert into product_category(category_name, category_type) values (#{categoryName, jdbcType = VARCHAR}," +
            "#{categoryType,jdbcType = INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 以对象的方式插入
     *
     * @param productCategory
     * @return
     */
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName , jdbcType = VARCHAR}," +
            "#{categoryType , jdbcType = INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    //查询部分字段信息
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    List<ProductCategory> findByCategoryType(@Param("categoryType") Integer type);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(String categoryName, Integer categoryType);


    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory category);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

}
