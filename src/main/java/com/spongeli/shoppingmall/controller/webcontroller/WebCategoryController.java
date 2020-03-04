package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import com.spongeli.shoppingmall.service.manager.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/27 10:30
 **/
@RestController
@RequestMapping("/web/cates")
public class WebCategoryController extends BaseController {

    @Autowired
    private CategoryService service;

    /**
     * 获取所有分类
     * 查询可见的分类
     * @return
     */
    @GetMapping
    public CommonResponse gainMallCategory() {
        return instanceSuccess(service.gainMallCategory(SystemConstant.QUERY_PART));
    }
}
