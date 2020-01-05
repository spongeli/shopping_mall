package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.MallUser;

public class RequestMallUSerBean extends MallUser {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
