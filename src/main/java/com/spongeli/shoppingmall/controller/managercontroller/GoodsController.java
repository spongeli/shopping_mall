package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.goods.AddGoodsInparam;
import com.spongeli.shoppingmall.entity.request.goods.GainGoodsListInparam;
import com.spongeli.shoppingmall.pojo.model.MallGoods;
import com.spongeli.shoppingmall.service.manager.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService service;

    /**
     * 分页获取商品数据
     *
     * @param inparam
     * @return
     */
    @PostMapping
    private CommonResponse gainGoodsList(@RequestBody GainGoodsListInparam inparam) {
        return instanceSuccess(service.gainGoodsList(inparam));
    }

    /**
     * 增加商品
     *
     * @param inparam
     * @return
     */
    @PostMapping("/add_goods")
    private CommonResponse addGoods(@RequestBody AddGoodsInparam inparam) {
        service.addGoods(inparam);
        return instanceSuccess();
    }

    /**
     * 修改商品状态
     */
    @PostMapping("/update_status/{goodIs}/{status}")
    private CommonResponse updateGoodsStatus(@PathVariable Integer goodIs, @PathVariable Byte status) {
        service.updateGoodsStatus(goodIs, status);
        return instanceSuccess();
    }

    /**
     * 修改商品其他信息
     */
    @PostMapping("/update/{goodIs}")
    private CommonResponse updateGoodsInfo(@PathVariable Integer goodIs, @RequestBody AddGoodsInparam inparam) {
        service.updateGoodsInfo(goodIs, inparam);
        return instanceSuccess();
    }

    @PostMapping("/{goodId}/delete")
    private CommonResponse deleteGoods(@PathVariable Integer goodId) {
        service.deleteGoods(goodId);
        return instanceSuccess();
    }
    @GetMapping("/{keyword}/query")
    private CommonResponse queryByKeyword(@PathVariable String keyword){
        return instanceSuccess(service.queryByKeyword(keyword));
    }
}
