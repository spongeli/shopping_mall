package com.spongeli.shoppingmall.controller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.service.webservice.index.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloWordController extends BaseController {
    @Autowired
    private MallUserService service;

    @GetMapping("/all")
     public CommonResponse helloWord(){
        return instanceSuccess( service.query());
    }
}
