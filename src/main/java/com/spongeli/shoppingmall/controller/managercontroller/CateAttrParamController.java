package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.cate.AddCateAttrInparam;
import com.spongeli.shoppingmall.entity.request.cate.UdateCateParamInparam;
import com.spongeli.shoppingmall.service.manager.CateAttrParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager/attr")
public class CateAttrParamController extends BaseController {

    @Autowired
    private CateAttrParamService service;

    /**
     * 获取数据
     * @param cateId
     * @param type  属性类别<>dynamic=动态属性&statics=静态属性
     * @return
     */
    @GetMapping("/{cateId}/{type}")
    private CommonResponse gainCateAttrParam(@PathVariable Integer cateId, @PathVariable String type) {
        return instanceSuccess(service.gainCateAttrParam(cateId, type));
    }

    /**
     * 增加属性
     * @param params
     * @return
     */
    @PostMapping("/add_attr")
    private CommonResponse addCateAttr(@Valid @RequestBody AddCateAttrInparam params) {
        service.addCateAttr(params);
        return instanceSuccess();
    }

    /**
     * 保存属性参数
     * @param attrId
     * @param param
     * @return
     */
    @PostMapping("/{attrId}/save_param")
    private CommonResponse addCateAttrParam(@PathVariable Integer attrId,@RequestParam("param") String param) {
        service.addCateAttrParam(attrId,param);
        return instanceSuccess();
    }

    /**
     * 删除属性
     * @return
     */
    @PostMapping("/{attrId}/delete")
    private CommonResponse deleteCateParam(@PathVariable Integer attrId){
        service.deleteCateParam(attrId);
        return instanceSuccess();
    }
    /**
     * 修改
     * @return
     */
    @PostMapping("/{attrId}/update")
    private CommonResponse updateCateParam(@PathVariable Integer attrId,@RequestBody UdateCateParamInparam inparam){
        service.updateCateParam(attrId,inparam);
        return instanceSuccess();
    }

}
