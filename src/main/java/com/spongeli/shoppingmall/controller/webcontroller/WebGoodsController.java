package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.goods.GainGoodsListInparam;
import com.spongeli.shoppingmall.service.manager.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/5 11:06
 **/
@RestController
@RequestMapping("/web/goods")
public class WebGoodsController extends BaseController {
    @Autowired
    private GoodsService service;

    /**
     * 获取商品列表
     * @param inparam
     * @return
     */
    @PostMapping
    private CommonResponse gainGoodsList(@RequestBody GainGoodsListInparam inparam) {
        return instanceSuccess(service.gainGoodsList(true, inparam));
    }

    /**
     * 通过id查询商品详情
     * @param goodId
     * @return
     */
    @GetMapping("/{goodId}")
    private CommonResponse gainGoodById(@PathVariable Integer goodId){
        return instanceSuccess(service.GainGoodById(goodId));
    }
}
