package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.bean.MallCategoryEx;
import com.spongeli.shoppingmall.common.bean.MallMenusEx;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.pojo.dao.MallCategoryMapper;
import com.spongeli.shoppingmall.pojo.model.MallCategory;
import com.spongeli.shoppingmall.pojo.model.MallCategoryExample;
import com.spongeli.shoppingmall.pojo.model.MallMenus;
import com.spongeli.shoppingmall.service.manager.CategoryService;
import com.spongeli.shoppingmall.utils.common.TreeCategoryUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl extends BaseService implements CategoryService {
    @Autowired
    private MallCategoryMapper mapper;

    /**
     * 获取当前用的商品分类列表
     * @return
     */
    @Override
    public List<MallCategoryEx> gainMallCategory() {
        List<MallCategory> list = mapper.selectByExample(new MallCategoryExample());
        if (CollectionUtils.isEmpty(list)) return new ArrayList<>();
        return TreeCategoryUtil.toTree(categoryToCategoryEx(list));
    }












    private List<MallCategoryEx> categoryToCategoryEx(List<MallCategory> cates) {
        List<MallCategoryEx> list = new ArrayList<>();
        cates.stream().forEach(item -> {
            MallCategoryEx ex = new MallCategoryEx();
            BeanUtils.copyProperties(item, ex);
            list.add(ex);
        });
        return list;
    }
}
