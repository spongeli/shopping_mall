package com.spongeli.shoppingmall.entity.request.goods;

import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;

public class GainGoodsListInparam {
    private String search;
    private String orderRule; //排序规则<> 1=综合排序&2=销量排序&3=价格排序（倒序）&4=价格排序（顺序）
    private Integer cateId;
    private PageHeplerInparam pageInparam = new PageHeplerInparam();

    public static final String ORDER_RULE_1 = "1";
    public static final String ORDER_RULE_2 = "2";
    public static final String ORDER_RULE_3 = "3";
    public static final String ORDER_RULE_4 = "4";

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public PageHeplerInparam getPageInparam() {
        return pageInparam;
    }

    public void setPageInparam(PageHeplerInparam pageInparam) {
        this.pageInparam = pageInparam;
    }

    public String getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(String orderRule) {
        this.orderRule = orderRule;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }
}
