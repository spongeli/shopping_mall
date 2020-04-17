package com.spongeli.shoppingmall.service.web;

import com.spongeli.shoppingmall.entity.request.user.WebDoLoginInparam;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:58
 **/
public interface WebUserService {
    Object wxlogin(WebDoLoginInparam inparam);
}
