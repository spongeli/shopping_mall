package com.spongeli.shoppingmall.service.manager;

import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.entity.request.goods.AddGoodsInparam;
import com.spongeli.shoppingmall.entity.request.goods.GainGoodsListInparam;
import com.spongeli.shoppingmall.pojo.model.MallGoods;

import java.util.List;

public interface GoodsService {

    PageInfo<MallGoods> gainGoodsList(GainGoodsListInparam inparam);

    void addGoods(AddGoodsInparam inparam);

    void updateGoodsStatus(Integer goodIs, Byte status);

    void updateGoodsInfo(Integer goodIs, AddGoodsInparam inparam);

    void deleteGoods(Integer goodId);

    List<MallGoods> queryByKeyword(String keyword);
}
