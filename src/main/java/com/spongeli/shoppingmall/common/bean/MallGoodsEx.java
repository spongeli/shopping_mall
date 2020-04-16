package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.MallGoods;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/16 15:06
 **/
public class MallGoodsEx extends MallGoods {
    private List<Integer> dynamicParamList;
    private List<Integer> serviceParamList;
    private List<Integer> staticsParamList;

    public List<Integer> getDynamicParamList() {
        return dynamicParamList;
    }

    public void setDynamicParamList(List<Integer> dynamicParamList) {
        this.dynamicParamList = dynamicParamList;
    }

    public List<Integer> getServiceParamList() {
        return serviceParamList;
    }

    public void setServiceParamList(List<Integer> serviceParamList) {
        this.serviceParamList = serviceParamList;
    }

    public List<Integer> getStaticsParamList() {
        return staticsParamList;
    }

    public void setStaticsParamList(List<Integer> staticsParamList) {
        this.staticsParamList = staticsParamList;
    }
}
