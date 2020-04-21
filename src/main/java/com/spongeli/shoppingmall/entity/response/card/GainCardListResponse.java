package com.spongeli.shoppingmall.entity.response.card;

import java.util.Date;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/21 9:46
 **/
public class GainCardListResponse {
    private Integer cardId;
    private Integer goodId;
    private Integer number;
    private String selectStyle;
    private Date createTime;
    private Integer goodsCount;
    private String goodsHotsLabel;
    private String goodsName;
    private String goodsHeaderImg;
    private Double goodsPrice;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
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

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsHotsLabel() {
        return goodsHotsLabel;
    }

    public void setGoodsHotsLabel(String goodsHotsLabel) {
        this.goodsHotsLabel = goodsHotsLabel;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsHeaderImg() {
        return goodsHeaderImg;
    }

    public void setGoodsHeaderImg(String goodsHeaderImg) {
        this.goodsHeaderImg = goodsHeaderImg;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
