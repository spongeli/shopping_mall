package com.spongeli.shoppingmall.pojo.model;

import java.io.Serializable;
import java.util.Date;

public class MallCard implements Serializable {
    private Integer cardId;

    private Integer userid;

    private Integer goodId;

    private String selectStyle;

    private Integer number;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getSelectStyle() {
        return selectStyle;
    }

    public void setSelectStyle(String selectStyle) {
        this.selectStyle = selectStyle == null ? null : selectStyle.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        sb.append(", cardId=").append(cardId);
        sb.append(", userid=").append(userid);
        sb.append(", goodId=").append(goodId);
        sb.append(", selectStyle=").append(selectStyle);
        sb.append(", number=").append(number);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}