package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.ShoppingUser;
import com.spongeli.shoppingmall.pojo.model.ShoppingUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingUserMapper {
    long countByExample(ShoppingUserExample example);

    int deleteByExample(ShoppingUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(ShoppingUser record);

    int insertSelective(ShoppingUser record);

    List<ShoppingUser> selectByExample(ShoppingUserExample example);

    ShoppingUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") ShoppingUser record, @Param("example") ShoppingUserExample example);

    int updateByExample(@Param("record") ShoppingUser record, @Param("example") ShoppingUserExample example);

    int updateByPrimaryKeySelective(ShoppingUser record);

    int updateByPrimaryKey(ShoppingUser record);
}