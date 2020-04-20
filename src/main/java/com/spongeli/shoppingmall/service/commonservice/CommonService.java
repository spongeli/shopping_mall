package com.spongeli.shoppingmall.service.commonservice;

import javax.servlet.http.HttpServletRequest;

public interface CommonService {
    boolean checkVerifyCode(HttpServletRequest request,String verify);

    void sendVerify(String username, HttpServletRequest request);

    String genOrderNoByRedis(String prefix);
}
