package com.spongeli.shoppingmall.service.manager;

import com.spongeli.shoppingmall.entity.request.user.manager.DoLoginInparam;
import com.spongeli.shoppingmall.entity.response.user.DoLoginOutparam;
import com.spongeli.shoppingmall.pojo.model.MallUser;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:48
 **/
public interface MallUserService {
    List<MallUser> query();

    DoLoginOutparam doLogin(DoLoginInparam inparam);

    void outLogin();
}
