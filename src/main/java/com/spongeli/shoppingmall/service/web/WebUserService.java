package com.spongeli.shoppingmall.service.web;

import com.spongeli.shoppingmall.entity.request.user.web.DoLoginPwdInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoRegisterInparam;
import com.spongeli.shoppingmall.entity.request.user.web.WebDoLoginInparam;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:58
 **/
public interface WebUserService {
    Object wxlogin(WebDoLoginInparam inparam);

    void doRegister(DoRegisterInparam inparam);

    Object doLoginByPwd(DoLoginPwdInparam inparam);
}
