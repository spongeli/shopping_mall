package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.ShoppingUser;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 15:05
 **/
public class ShoppingUserEx extends ShoppingUser {
    private String sessionKey;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
