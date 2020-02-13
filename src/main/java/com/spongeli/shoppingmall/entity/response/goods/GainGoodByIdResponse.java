package com.spongeli.shoppingmall.entity.response.goods;

import com.spongeli.shoppingmall.pojo.model.MallCateParams;
import com.spongeli.shoppingmall.pojo.model.MallGoods;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/5 11:53
 **/
public class GainGoodByIdResponse {
    private MallGoods goods;
    // 动态属性
    private List<MallCateParams> dynamicCates;
    // 静态属性
    private List<MallCateParams> staticsCates;
    public MallGoods getGoods() {
        return goods;
    }

    public void setGoods(MallGoods goods) {
        this.goods = goods;
    }

    public List<MallCateParams> getDynamicCates() {
        return dynamicCates;
    }

    public void setDynamicCates(List<MallCateParams> dynamicCates) {
        this.dynamicCates = dynamicCates;
    }

    public List<MallCateParams> getStaticsCates() {
        return staticsCates;
    }

    public void setStaticsCates(List<MallCateParams> staticsCates) {
        this.staticsCates = staticsCates;
    }
}
