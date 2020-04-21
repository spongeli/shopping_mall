package com.spongeli.shoppingmall.entity.request.card;

import javax.validation.constraints.NotNull;

public class AddCardInparam {
    @NotNull(message = "商品ID不能为空")
    private Integer goodsId;
    private Integer number = 1;
    @NotNull(message = "商品规格不能为空")
    private String selectStyle;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSelectStyle() {
        return selectStyle;
    }

    public void setSelectStyle(String selectStyle) {
        this.selectStyle = selectStyle;
    }
}
