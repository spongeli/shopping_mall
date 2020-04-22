package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.address.AddAddressInparam;
import com.spongeli.shoppingmall.service.web.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/web/address")
public class WebAddressController extends BaseController {
    @Autowired
    private AddressService service;


    /**
     * 拉去地址列表
     *
     * @return
     */
    @GetMapping
    public CommonResponse gainUserAddresss() {
        return instanceSuccess(service.gainUserAddresss());
    }

    /**
     * 增加地址
     *
     * @return
     */
    @PostMapping("/add")
    public CommonResponse addAddress(@RequestBody @Valid AddAddressInparam inparam) {
        service.addAddress(inparam);
        return instanceSuccess();
    }

    /**
     * 修改地址
     *
     * @param inparam
     * @return
     */
    @PostMapping("/update/{id}")
    public CommonResponse updateAddress(@PathVariable("id") Integer id, @RequestBody @Valid AddAddressInparam inparam) {
        service.updateAddress(id, inparam);
        return instanceSuccess();
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @PostMapping("/delete/{id}")
    public CommonResponse deleteAddress(@PathVariable("id") Integer id) {
        service.deleteAddress(id);
        return instanceSuccess();
    }

    /**
     * 设为默认
     *
     * @param
     * @return
     */
    @PostMapping("/default/{id}")
    public CommonResponse defaultAddress(@PathVariable("id") Integer id) {
        service.defaultAddress(id);
        return instanceSuccess();
    }
}
