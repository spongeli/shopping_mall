package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.util.ServiceUtil;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 11:15
 **/
public class WebBaseService extends BaseService {

    // 获取当前用户信息
    protected ShoppingUserEx getCurrentUser() {
        ShoppingUserEx currentUser = WebRequestHolder.getCurrentUser();
        if (Objects.isNull(currentUser)) {
            throw new SystemException("当前用户没登录");
        }
        return currentUser;
    }

    protected Integer getCurrentUserId() {
        return getCurrentUser().getUserId();
    }

    // 获取当前用户信息的登陆token
    protected String getCurrentUserToken() {
        return Objects.isNull(WebRequestHolder.getCurrentUser()) ? "" : WebRequestHolder.getCurrentUser().getToken();
    }

    /**
     * 获取当前线程的访问IP
     *
     * @return
     */
    protected String getCurrentIp() {
        return ServiceUtil.getIpAddr(WebRequestHolder.getCurrentRequest());
    }

    /**
     * 获取当前线程的request
     *
     * @return
     */
    protected HttpServletRequest getRequest() {
        return WebRequestHolder.getCurrentRequest();
    }

}
