package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallCateParams;
import com.spongeli.shoppingmall.pojo.model.MallCateParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallCateParamsMapper {
    long countByExample(MallCateParamsExample example);

    int deleteByExample(MallCateParamsExample example);

    int deleteByPrimaryKey(Integer attrId);

    int insert(MallCateParams record);

    int insertSelective(MallCateParams record);

    List<MallCateParams> selectByExample(MallCateParamsExample example);

    MallCateParams selectByPrimaryKey(Integer attrId);

    int updateByExampleSelective(@Param("record") MallCateParams record, @Param("example") MallCateParamsExample example);

    int updateByExample(@Param("record") MallCateParams record, @Param("example") MallCateParamsExample example);

    int updateByPrimaryKeySelective(MallCateParams record);

    int updateByPrimaryKey(MallCateParams record);
}