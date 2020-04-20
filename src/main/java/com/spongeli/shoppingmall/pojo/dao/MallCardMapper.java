package com.spongeli.shoppingmall.pojo.dao;

import com.spongeli.shoppingmall.pojo.model.MallCard;
import com.spongeli.shoppingmall.pojo.model.MallCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallCardMapper {
    long countByExample(MallCardExample example);

    int deleteByExample(MallCardExample example);

    int deleteByPrimaryKey(@Param("goodId") Integer goodId, @Param("userid") Integer userid);

    int insert(MallCard record);

    int insertSelective(MallCard record);

    List<MallCard> selectByExample(MallCardExample example);

    MallCard selectByPrimaryKey(@Param("goodId") Integer goodId, @Param("userid") Integer userid);

    int updateByExampleSelective(@Param("record") MallCard record, @Param("example") MallCardExample example);

    int updateByExample(@Param("record") MallCard record, @Param("example") MallCardExample example);

    int updateByPrimaryKeySelective(MallCard record);

    int updateByPrimaryKey(MallCard record);
}