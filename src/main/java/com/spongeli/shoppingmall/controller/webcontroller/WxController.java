package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.web.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 9:37
 **/
@RestController
@RequestMapping("/web/wx")
public class WxController extends BaseController {
    @Autowired
    private WxService service;

    @GetMapping("/login")
    private CommonResponse wxLogin(@RequestParam String token){
        return instanceSuccess(service.login(token));
    }
}
