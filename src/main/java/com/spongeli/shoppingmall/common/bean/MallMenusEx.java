package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.MallMenus;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:14
 **/
public class MallMenusEx extends MallMenus {
    private List<MallMenusEx> childrenList;

    public List<MallMenusEx> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MallMenusEx> childrenList) {
        this.childrenList = childrenList;
    }
}
