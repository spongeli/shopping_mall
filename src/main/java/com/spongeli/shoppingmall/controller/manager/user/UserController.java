package com.spongeli.shoppingmall.controller.manager.user;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.service.webservice.index.impl.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private MallUserService service;
    @PostMapping("/login")
    public CommonResponse doLogin(@Valid @RequestBody DoLoginInparam inparam){
        return instanceSuccess(service.doLogin(inparam));
    }
}
