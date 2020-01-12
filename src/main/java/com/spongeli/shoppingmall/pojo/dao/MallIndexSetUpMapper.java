package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallIndexSetUp;
import com.spongeli.shoppingmall.pojo.model.MallIndexSetUpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallIndexSetUpMapper {
    long countByExample(MallIndexSetUpExample example);

    int deleteByExample(MallIndexSetUpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallIndexSetUp record);

    int insertSelective(MallIndexSetUp record);

    List<MallIndexSetUp> selectByExample(MallIndexSetUpExample example);

    MallIndexSetUp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallIndexSetUp record, @Param("example") MallIndexSetUpExample example);

    int updateByExample(@Param("record") MallIndexSetUp record, @Param("example") MallIndexSetUpExample example);

    int updateByPrimaryKeySelective(MallIndexSetUp record);

    int updateByPrimaryKey(MallIndexSetUp record);
}