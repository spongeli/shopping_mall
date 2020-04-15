package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallGoodsServices;
import com.spongeli.shoppingmall.pojo.model.MallGoodsServicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallGoodsServicesMapper {
    long countByExample(MallGoodsServicesExample example);

    int deleteByExample(MallGoodsServicesExample example);

    int deleteByPrimaryKey(Integer serviceId);

    int insert(MallGoodsServices record);

    int insertSelective(MallGoodsServices record);

    List<MallGoodsServices> selectByExample(MallGoodsServicesExample example);

    MallGoodsServices selectByPrimaryKey(Integer serviceId);

    int updateByExampleSelective(@Param("record") MallGoodsServices record, @Param("example") MallGoodsServicesExample example);

    int updateByExample(@Param("record") MallGoodsServices record, @Param("example") MallGoodsServicesExample example);

    int updateByPrimaryKeySelective(MallGoodsServices record);

    int updateByPrimaryKey(MallGoodsServices record);
}