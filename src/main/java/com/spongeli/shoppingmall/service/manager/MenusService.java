package com.spongeli.shoppingmall.service.manager;

import com.spongeli.shoppingmall.common.bean.MallMenusEx;

import java.util.List;

public interface MenusService {
    List<MallMenusEx> findAllMallMenus();
}
