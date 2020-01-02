package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.bean.MallMenusEx;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import com.spongeli.shoppingmall.service.manager.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:20
 **/
@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<MallMenusEx> findAllMallMenus() {
        return null;
    }
}
