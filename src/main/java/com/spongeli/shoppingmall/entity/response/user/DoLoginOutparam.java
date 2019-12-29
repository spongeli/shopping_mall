package com.spongeli.shoppingmall.entity.response.user;

import com.spongeli.shoppingmall.pojo.model.MallUser;

public class DoLoginOutparam {
    private String token;
    private MallUser user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }
}
