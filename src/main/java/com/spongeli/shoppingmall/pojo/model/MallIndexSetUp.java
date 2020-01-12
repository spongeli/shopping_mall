package com.spongeli.shoppingmall.pojo.model;

import java.io.Serializable;
import java.util.Date;

public class MallIndexSetUp implements Serializable {
    private Integer id;

    private String imgSrc;

    private Byte type;

    private Integer goodsId;

    private String backGroundColor;

    private Byte status;

    private Byte clickStatus;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(String backGroundColor) {
        this.backGroundColor = backGroundColor == null ? null : backGroundColor.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getClickStatus() {
        return clickStatus;
    }

    public void setClickStatus(Byte clickStatus) {
        this.clickStatus = clickStatus;
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
        sb.append(", id=").append(id);
        sb.append(", imgSrc=").append(imgSrc);
        sb.append(", type=").append(type);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", backGroundColor=").append(backGroundColor);
        sb.append(", status=").append(status);
        sb.append(", clickStatus=").append(clickStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}