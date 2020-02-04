package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.order.GainOrderListInparam;
import com.spongeli.shoppingmall.service.manager.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/4 9:58
 **/
@RestController
@RequestMapping("/manager/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService service;

    /**
     * 获取商品订单列表
     * @param inparam
     * @return
     */
    @PostMapping
    private CommonResponse gainOrderList(@RequestBody GainOrderListInparam inparam){
        return instanceSuccess(service.gainOrderList(inparam));
    }
}
