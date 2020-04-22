package com.spongeli.shoppingmall.pojo.dao.common;

import com.spongeli.shoppingmall.entity.response.card.GainCardListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebCardMapper {

    @Select("SELECT\n" +
            "\tt1.card_id,\n" +
            "\tt1.good_id,\n" +
            "\tt1.number,\n" +
            "\tt1.select_style,\n" +
            "\tt1.create_time,\n" +
            "\tt2.goods_count,\n" +
            "\tt2.goods_hots_label,\n" +
            "\tt2.goods_name,\n" +
            "\tt2.goods_header_img,\n" +
            "\tt2.goods_status,\n" +
            "\tt2.goods_price\n" +
            "FROM\n" +
            "\tmall_card t1\n" +
            "\tLEFT JOIN mall_goods t2 ON t1.good_id = t2.goods_id\n" +
            "\tWHERE t1.userid  = #{userId} ORDER BY t1.create_time desc")
    List<GainCardListResponse> gainCardListResponse(@Param("userId") Integer userId);
}
