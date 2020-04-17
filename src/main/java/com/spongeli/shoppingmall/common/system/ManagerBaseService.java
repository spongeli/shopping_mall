package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.bean.RequestMallUSerBean;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:22
 **/
public class ManagerBaseService extends BaseService{
    // 获取当前用户信息
    protected RequestMallUSerBean getCurrentUser(){
        return RequestHolder.getCurrentUser();
    }

    // 获取当前用户信息的登陆token
    protected String getCurrentUserToken(){
        return RequestHolder.getCurrentUser().getToken();
    }

}
