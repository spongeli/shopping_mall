package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.card.AddCardInparam;
import com.spongeli.shoppingmall.service.web.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 购物车控制器
 */
@RestController
@RequestMapping("/web/card")
public class WebCardController  extends BaseController {
    @Autowired
    private CardService service;

    /**
     * 增加购物车
     * @param inparam
     * @return
     */
    @PostMapping("/add")
    public CommonResponse addCard(@RequestBody @Valid AddCardInparam inparam){
        service.addCard(inparam);
        return instanceSuccess();
    }

    /**
     * 获取购物车列表
     * @param inparam
     * @return
     */
    @PostMapping("/list")
    public CommonResponse GainCardList(@RequestBody PageHeplerInparam inparam){
        return instanceSuccess(service.GainCardList(inparam));
    }

    /**
     * 修改个数
     * @param id
     * @param number
     * @return
     */
    @GetMapping("/update/{id}")
    public CommonResponse updateCardNumber(@PathVariable("id")Integer id,@RequestParam("number") Integer number){
        service.updateCardNumber(id,number);
        return instanceSuccess();
    }

    @PostMapping("/delete/{id}")
    public CommonResponse deleteCard(@PathVariable("id")Integer id){
        service.deleteCard(id);
        return instanceSuccess();
    }
}
