package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallUserAddress;
import com.spongeli.shoppingmall.pojo.model.MallUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserAddressMapper {
    long countByExample(MallUserAddressExample example);

    int deleteByExample(MallUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    List<MallUserAddress> selectByExample(MallUserAddressExample example);

    MallUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallUserAddress record, @Param("example") MallUserAddressExample example);

    int updateByExample(@Param("record") MallUserAddress record, @Param("example") MallUserAddressExample example);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);
}