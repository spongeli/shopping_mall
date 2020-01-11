package com.spongeli.shoppingmall.entity.request.goods;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AddGoodsInparam {
    @NotNull(message = "分类ID不能为空")
    private Integer cateId;
    private String cateName;
    @NotEmpty(message = "商品名称不能为空")
    private String goodsName;
    @NotNull(message = "商品价格不能为空")
    private BigDecimal goodsPrice;
    @NotNull(message = "商品重量")
    private Double goodsWeight;
    private BigDecimal goodsOriginalPrice;
    @NotEmpty(message = "商品头图不能为空")
    private String goodsHeaderImg;
    @NotNull(message = "商品库存不能为空")
    private Integer goodsCount;
    @NotEmpty(message = "商品详情不能为空")
    private String goodsDetail;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getGoodsOriginalPrice() {
        return goodsOriginalPrice;
    }

    public void setGoodsOriginalPrice(BigDecimal goodsOriginalPrice) {
        this.goodsOriginalPrice = goodsOriginalPrice;
    }

    public String getGoodsHeaderImg() {
        return goodsHeaderImg;
    }

    public void setGoodsHeaderImg(String goodsHeaderImg) {
        this.goodsHeaderImg = goodsHeaderImg;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
}
