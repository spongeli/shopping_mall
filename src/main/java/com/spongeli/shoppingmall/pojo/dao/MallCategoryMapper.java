package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallCategory;
import com.spongeli.shoppingmall.pojo.model.MallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallCategoryMapper {
    long countByExample(MallCategoryExample example);

    int deleteByExample(MallCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(MallCategory record);

    int insertSelective(MallCategory record);

    List<MallCategory> selectByExample(MallCategoryExample example);

    MallCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByExample(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByPrimaryKeySelective(MallCategory record);

    int updateByPrimaryKey(MallCategory record);
}