package com.spongeli.shoppingmall.service.web;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 9:38
 **/
public interface WxService {
    JSONObject login(String token);
}
