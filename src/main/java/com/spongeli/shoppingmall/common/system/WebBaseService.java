package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.util.ServiceUtil;

import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 11:15
 **/
public class WebBaseService extends BaseService {

    // 获取当前用户信息
    protected ShoppingUserEx getCurrentUser() {
        return WebRequestHolder.getCurrentUser();
    }

    // 获取当前用户信息的登陆token
    protected String getCurrentUserToken() {
        return Objects.isNull(WebRequestHolder.getCurrentUser()) ? "" : WebRequestHolder.getCurrentUser().getToken();
    }

    /**
     * 获取当前线程的访问IP
     * @return
     */
    protected String getCurrentIp(){
        return ServiceUtil.getIpAddr(WebRequestHolder.getCurrentRequest());
    }
}
