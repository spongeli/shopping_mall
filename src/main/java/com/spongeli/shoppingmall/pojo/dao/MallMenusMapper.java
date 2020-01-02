package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallMenus;
import com.spongeli.shoppingmall.pojo.model.MallMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMenusMapper {
    long countByExample(MallMenusExample example);

    int deleteByExample(MallMenusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallMenus record);

    int insertSelective(MallMenus record);

    List<MallMenus> selectByExample(MallMenusExample example);

    MallMenus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallMenus record, @Param("example") MallMenusExample example);

    int updateByExample(@Param("record") MallMenus record, @Param("example") MallMenusExample example);

    int updateByPrimaryKeySelective(MallMenus record);

    int updateByPrimaryKey(MallMenus record);
}