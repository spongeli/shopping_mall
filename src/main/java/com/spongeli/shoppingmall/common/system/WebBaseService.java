package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;

import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 11:15
 **/
public class WebBaseService extends BaseService {

    // 获取当前用户信息
    protected ShoppingUserEx getCurrentUser() {
        return ShoppingUserHolder.getCurrentUser();
    }

    // 获取当前用户信息的登陆token
    protected String getCurrentUserToken() {
        return Objects.isNull(ShoppingUserHolder.getCurrentUser()) ? "" : ShoppingUserHolder.getCurrentUser().getToken();
    }
}
