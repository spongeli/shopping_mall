package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import com.spongeli.shoppingmall.service.manager.IndexSetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/5 10:22
 **/
@RestController
@RequestMapping("/web/index")
public class WebIndexSetUpController extends BaseController {
    @Autowired
    private IndexSetUpService service;

    /**
     * 获取首页数据
     * @return
     */
    @GetMapping
    private CommonResponse gainIndexSetUpList(){
        return instanceSuccess(service.gainIndexSetUpList(SystemConstant.QUERY_PART));
    }
}
