package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.card.AddCardInparam;
import com.spongeli.shoppingmall.service.web.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 购物车控制器
 */
@RestController
@RequestMapping("/web/card")
public class WebCardController  extends BaseController {
    @Autowired
    private CardService service;

    @PostMapping("/add")
    public CommonResponse addCard(@RequestBody @Valid AddCardInparam inparam){
        service.addCard(inparam);
        return instanceSuccess();
    }

}
