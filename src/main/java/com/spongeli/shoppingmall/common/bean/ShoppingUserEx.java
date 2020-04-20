package com.spongeli.shoppingmall.common.bean;

import com.spongeli.shoppingmall.pojo.model.ShoppingUser;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 15:05
 **/
public class ShoppingUserEx extends ShoppingUser {
    private String token;
    private String sessionKey;
    private String ip;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
