package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.manager.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/cate")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public CommonResponse gainMallCategory(){
        return instanceSuccess(service.gainMallCategory());
    }
}
