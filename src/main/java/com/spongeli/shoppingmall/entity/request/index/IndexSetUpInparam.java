package com.spongeli.shoppingmall.entity.request.index;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/12 9:34
 **/
public class IndexSetUpInparam {

    @NotEmpty(message = "图片地址不能为空")
    private String imgSrc;
    @NotNull(message = "类型不能为空")
    private Byte type;
    //    @NotNull(message = "商品ID不能为空")
    private Integer goodsId;
    private String goodsName;
    private String activityName;
    private String activityPath;
    private Integer level;
    private String backGroundColor;
    @NotNull(message = "是否上架不能为空")
    private Byte status;
    @NotNull(message = "是否可点击上架不能为空")
    private Byte clickStatus;


    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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

    public Integer getLevel() {
        return level;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(String backGroundColor) {
        this.backGroundColor = backGroundColor;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }
}
