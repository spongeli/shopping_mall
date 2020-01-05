package com.spongeli.shoppingmall.service.manager;

import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.entity.request.user.GainShoppingUsersInparam;
import com.spongeli.shoppingmall.entity.request.user.UpdateShoppingUserInparam;
import com.spongeli.shoppingmall.entity.response.user.DoLoginOutparam;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;

import javax.validation.Valid;
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
