package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.user.GainShoppingUsersInparam;
import com.spongeli.shoppingmall.entity.request.user.UpdateShoppingUserInparam;
import com.spongeli.shoppingmall.service.manager.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/consumer")
public class ConsumerController extends BaseController {
    @Autowired
    private ConsumerService service;

    @PostMapping("/shopping_users")
    public CommonResponse gainShoppingUsers(@RequestBody GainShoppingUsersInparam inparam){
        return instanceSuccess(service.gainShoppingUsers(inparam));
    }
    @PostMapping("/{userid}/upadte_status")
    public CommonResponse updateShoppingUser(@PathVariable Integer userid, @RequestBody UpdateShoppingUserInparam inparam){
        service.updateShoppingUser(userid,inparam);
        return instanceSuccess();
    }
}
