package com.spongeli.shoppingmall.service.manager;

import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.entity.request.user.GainShoppingUsersInparam;
import com.spongeli.shoppingmall.entity.request.user.UpdateShoppingUserInparam;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;

public interface ConsumerService {

    PageInfo<ShoppingUser> gainShoppingUsers(GainShoppingUsersInparam inparam);

    void updateShoppingUser(Integer userid, UpdateShoppingUserInparam inparam);
}
