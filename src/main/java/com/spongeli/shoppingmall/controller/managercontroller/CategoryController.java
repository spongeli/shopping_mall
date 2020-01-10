package com.spongeli.shoppingmall.controller.managercontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.pojo.model.MallCategory;
import com.spongeli.shoppingmall.service.manager.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/cate")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService service;

    /**
     * 获取所有分类
     * @param scope<>all=全部&part=可见状态
     * @return
     */
    @GetMapping
    public CommonResponse gainMallCategory(@RequestParam String scope) {
        return instanceSuccess(service.gainMallCategory(scope));
    }

    /**
     * 获取所有分类
     *
     * @return
     */
    @GetMapping("/{cateId}")
    public CommonResponse gainMallCategoryById(@PathVariable Integer cateid) {
        return instanceSuccess(service.gainMallCategoryById(cateid));
    }

    /**
     * 删除分类
     */
    @PostMapping("/{cateId}/delete")
    public CommonResponse deleteCategory(@PathVariable Integer cateId) {
        service.deleteCategory(cateId);
        return instanceSuccess();
    }

    /**
     * 删除分类
     */
    @PostMapping("/{cateId}/update")
    public CommonResponse updateCategory(@PathVariable Integer cateId, @RequestBody MallCategory category) {
        service.updateCategory(cateId, category);
        return instanceSuccess();
    }

    /**
     * 增加分类
     */
    @PostMapping("/add")
    public CommonResponse addCategory(@RequestBody MallCategory category) {
        service.addCategory(category);
        return instanceSuccess();
    }
}
