package com.spongeli.shoppingmall.pojo.model;

import java.io.Serializable;
import java.util.Date;

public class MallCateParams implements Serializable {
    private Integer attrId;

    private Integer cateId;

    private String attrName;

    private String attrType;

    private Byte attrStatus;

    private String attrList;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType == null ? null : attrType.trim();
    }

    public Byte getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(Byte attrStatus) {
        this.attrStatus = attrStatus;
    }

    public String getAttrList() {
        return attrList;
    }

    public void setAttrList(String attrList) {
        this.attrList = attrList == null ? null : attrList.trim();
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
        sb.append(", attrId=").append(attrId);
        sb.append(", cateId=").append(cateId);
        sb.append(", attrName=").append(attrName);
        sb.append(", attrType=").append(attrType);
        sb.append(", attrStatus=").append(attrStatus);
        sb.append(", attrList=").append(attrList);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}