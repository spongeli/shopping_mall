package com.spongeli.shoppingmall.service.commonservice;

import javax.servlet.http.HttpServletRequest;

public interface CommonService {
    boolean checkVerifyCode(HttpServletRequest request,String verify);
}
