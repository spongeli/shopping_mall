package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.index.IndexSetUpInparam;
import com.spongeli.shoppingmall.entity.request.index.UpdateIndexSetUpInparam;
import com.spongeli.shoppingmall.service.manager.IndexSetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/12 9:12
 **/
@RestController
@RequestMapping("/manager/index")
public class IndexSetUpController extends BaseController {
    @Autowired
    private IndexSetUpService service;

    /**
     *
     * @param scope<>all&part(不上架的不查出)
     * @return
     */
    @GetMapping
    public CommonResponse gainIndexSetUpList(@RequestParam String scope){
        return instanceSuccess(service.gainIndexSetUpList(scope));
    }

    /**
     * 新插入一条记录
     * @param inparam
     * @return
     */
    @PostMapping
    public CommonResponse addIndexSetUp(@Valid @RequestBody IndexSetUpInparam inparam){
        service.addIndexSetUp(inparam);
        return instanceSuccess();
    }

    @PostMapping("/update/{id}")
    public CommonResponse updateIndexSetUp(@PathVariable Integer id,@RequestBody UpdateIndexSetUpInparam inparam){
        service.updateIndexSetUp(id,inparam);
        return instanceSuccess();
    }

    @PostMapping("/delete/{id}")
    public CommonResponse delete(@PathVariable Integer id){
        service.delete(id);
        return instanceSuccess();
    }
}