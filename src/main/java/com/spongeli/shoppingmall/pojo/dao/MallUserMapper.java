package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallUser;
import java.util.List;

public interface MallUserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(MallUser record);

    MallUser selectByPrimaryKey(Long userid);

    List<MallUser> selectAll();

    int updateByPrimaryKey(MallUser record);
}