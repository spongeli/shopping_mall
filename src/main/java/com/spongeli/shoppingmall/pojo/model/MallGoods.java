package com.spongeli.shoppingmall.pojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MallGoods implements Serializable {
    private Integer goodsId;

    private Integer cateId;

    private String cateName;

    private String goodsHotsLabel;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Double goodsWeight;

    private BigDecimal goodsOriginalPrice;

    private String goodsHeaderImg;

    private Integer goodsCount;

    private String goodsDetail;

    private Byte goodsStatus;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

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
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public String getGoodsHotsLabel() {
        return goodsHotsLabel;
    }

    public void setGoodsHotsLabel(String goodsHotsLabel) {
        this.goodsHotsLabel = goodsHotsLabel == null ? null : goodsHotsLabel.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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
        this.goodsHeaderImg = goodsHeaderImg == null ? null : goodsHeaderImg.trim();
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
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    public Byte getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Byte goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", cateId=").append(cateId);
        sb.append(", cateName=").append(cateName);
        sb.append(", goodsHotsLabel=").append(goodsHotsLabel);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsWeight=").append(goodsWeight);
        sb.append(", goodsOriginalPrice=").append(goodsOriginalPrice);
        sb.append(", goodsHeaderImg=").append(goodsHeaderImg);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", goodsDetail=").append(goodsDetail);
        sb.append(", goodsStatus=").append(goodsStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}