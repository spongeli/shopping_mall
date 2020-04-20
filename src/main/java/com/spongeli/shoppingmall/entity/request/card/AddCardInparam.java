package com.spongeli.shoppingmall.entity.request.card;

import javax.validation.constraints.NotNull;

public class AddCardInparam {
    @NotNull(message = "商品ID不能为空")
    private Integer goodsId;
    private Integer number = 1;

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
}
