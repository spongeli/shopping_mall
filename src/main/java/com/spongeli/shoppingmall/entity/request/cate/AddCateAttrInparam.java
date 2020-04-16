package com.spongeli.shoppingmall.entity.request.cate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddCateAttrInparam {
    @NotEmpty(message = "属性名不能为空")
    private String attrName;
    @NotEmpty(message = "属性类别不能为空")
    private String attrType;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }
}
