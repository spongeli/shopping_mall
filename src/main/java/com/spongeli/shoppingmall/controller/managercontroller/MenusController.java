package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.manager.MallMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:09
 **/
@RestController
@RequestMapping("/manager/menus")
public class MenusController extends BaseController {
    @Autowired
    private MallMenusService service;

    /**
     * 获取菜单树
     * @return
     */
    @GetMapping
    public CommonResponse findAllMallMenus(){
        return instanceSuccess(service.findAllMallMenus());
    }
}
