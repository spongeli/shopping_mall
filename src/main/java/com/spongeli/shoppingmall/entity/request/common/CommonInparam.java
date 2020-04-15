package com.spongeli.shoppingmall.entity.request.common;

import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;

public class CommonInparam {
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
