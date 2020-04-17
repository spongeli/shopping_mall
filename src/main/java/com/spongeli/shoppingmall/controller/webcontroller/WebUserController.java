package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.entity.request.user.WebDoLoginInparam;
import com.spongeli.shoppingmall.service.web.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:56
 **/
@RestController
@RequestMapping("/web/user")
public class WebUserController extends BaseController {
    @Autowired
    private WebUserService service;

    @PostMapping("/wxlogin")
    public CommonResponse wxlogin(@RequestBody WebDoLoginInparam inparam){
        return instanceSuccess(service.wxlogin(inparam));
    }
}
