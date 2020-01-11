package com.spongeli.shoppingmall.service.manager;

import com.spongeli.shoppingmall.common.bean.MallCategoryEx;
import com.spongeli.shoppingmall.pojo.model.MallCategory;

import java.util.List;

public interface CategoryService {
    List<MallCategoryEx> gainMallCategory(String scope);

    void deleteCategory(Integer integer);

    void updateCategory(Integer integer, MallCategory category);

    void addCategory(MallCategory category);

    MallCategory gainMallCategoryById(Integer cateid);

    List<MallCategory> gainMallCategoryAll();
}
