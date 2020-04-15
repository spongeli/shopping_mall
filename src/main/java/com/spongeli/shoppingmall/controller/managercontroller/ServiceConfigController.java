package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.common.CommonInparam;
import com.spongeli.shoppingmall.entity.request.order.GainOrderListInparam;
import com.spongeli.shoppingmall.pojo.model.MallGoodsServices;
import com.spongeli.shoppingmall.service.manager.ServiceConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/4 9:58
 **/
@RestController
@RequestMapping("/manager/services")
public class ServiceConfigController extends BaseController {

    @Autowired
    private ServiceConfigService service;

    /**
     * 获取服务列表
     * @param inparam
     * @return
     */
    @PostMapping
    private CommonResponse gainServiceConfigList(@RequestBody CommonInparam inparam){
        return instanceSuccess(service.gainServiceConfigList(inparam));
    }

    @PostMapping("/add")
    private CommonResponse addServiceConfig(@RequestBody MallGoodsServices services){
        service.addServiceConfig(services);
        return instanceSuccess();
    }
}
