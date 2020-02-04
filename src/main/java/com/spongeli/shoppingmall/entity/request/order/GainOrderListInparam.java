package com.spongeli.shoppingmall.entity.request.order;

import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/4 10:03
 **/
public class GainOrderListInparam {
    private String search;
    private PageHeplerInparam pageInparam = new PageHeplerInparam();

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
}
