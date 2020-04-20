package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.MallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserMapper {
    long countByExample(MallUserExample example);

    int deleteByExample(MallUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    List<MallUser> selectByExample(MallUserExample example);

    MallUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") MallUser record, @Param("example") MallUserExample example);

    int updateByExample(@Param("record") MallUser record, @Param("example") MallUserExample example);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);
}