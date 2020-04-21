package com.spongeli.shoppingmall.service.web;

import com.spongeli.shoppingmall.entity.request.user.web.DoLoginPwdInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoLoginVerifyInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoRegisterInparam;
import com.spongeli.shoppingmall.entity.request.user.web.WebDoLoginInparam;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:58
 **/
public interface WebUserService {
    Object wxlogin(WebDoLoginInparam inparam);

    void doRegister(DoRegisterInparam inparam);

    Object doLoginByPwd(DoLoginPwdInparam inparam);

    Object doLoginVerify(DoLoginVerifyInparam inparam);

    void addScanGoods(List<Integer> ids);
}
