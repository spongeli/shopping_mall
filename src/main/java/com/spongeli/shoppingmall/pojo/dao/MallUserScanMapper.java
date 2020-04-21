package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallUserScan;
import com.spongeli.shoppingmall.pojo.model.MallUserScanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserScanMapper {
    long countByExample(MallUserScanExample example);

    int deleteByExample(MallUserScanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserScan record);

    int insertSelective(MallUserScan record);

    List<MallUserScan> selectByExample(MallUserScanExample example);

    MallUserScan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallUserScan record, @Param("example") MallUserScanExample example);

    int updateByExample(@Param("record") MallUserScan record, @Param("example") MallUserScanExample example);

    int updateByPrimaryKeySelective(MallUserScan record);

    int updateByPrimaryKey(MallUserScan record);
}