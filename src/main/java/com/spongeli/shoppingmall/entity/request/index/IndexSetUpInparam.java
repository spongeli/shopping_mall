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
    private Integer level;
    private String backGroundColor;

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
}
