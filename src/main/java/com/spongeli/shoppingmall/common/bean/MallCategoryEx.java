package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.MallCategory;

import java.util.List;

public class MallCategoryEx extends MallCategory {
    private List<MallCategoryEx> children;

    public List<MallCategoryEx> getChildren() {
        return children;
    }

    public void setChildren(List<MallCategoryEx> children) {
        this.children = children;
    }
}
