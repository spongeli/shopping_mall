package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 15:17
 **/
public class ShoppingUserHolder{
    // 保存当前线程的用户信息
    private static final ThreadLocal<ShoppingUserEx> userHolder = new ThreadLocal<>();
    // 保存当前线程的request信息
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();

    public static void  addAll(ShoppingUserEx sysUser,HttpServletRequest request){
        userHolder.set(sysUser);
        requestHolder.set(request);
    }

    public static void add(ShoppingUserEx sysUser){
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest request){
        requestHolder.set(request);
    }

    public static ShoppingUserEx getCurrentUser(){
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest(){
        return requestHolder.get();
    }

    public static void remove(){
        userHolder.remove();
        requestHolder.remove();
    }
}
