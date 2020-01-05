package com.spongeli.shoppingmall.common.bean;

public class PageHeplerInparam {
    private int pageSize = 10;
    private int pageCurrentPage = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCurrentPage() {
        return pageCurrentPage;
    }

    public void setPageCurrentPage(int pageCurrentPage) {
        this.pageCurrentPage = pageCurrentPage;
    }
}
