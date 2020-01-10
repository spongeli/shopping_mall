package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.bean.MallCategoryEx;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.pojo.dao.MallCategoryMapper;
import com.spongeli.shoppingmall.pojo.model.MallCategory;
import com.spongeli.shoppingmall.pojo.model.MallCategoryExample;
import com.spongeli.shoppingmall.service.manager.CategoryService;
import com.spongeli.shoppingmall.utils.StringUtils;
import com.spongeli.shoppingmall.utils.common.TreeCategoryUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl extends BaseService implements CategoryService {
    @Autowired
    private MallCategoryMapper mapper;

    /**
     * 获取当前用的商品分类列表
     *
     * @param scope
     * @return
     */
    @Override
    public List<MallCategoryEx> gainMallCategory(String scope) {
        MallCategoryExample example = new MallCategoryExample();
        if (!StringUtils.isEquals(scope, "all")) {
            example.createCriteria().andStatusEqualTo((byte) 0);
        }
        List<MallCategory> list = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) return new ArrayList<>();
        return TreeCategoryUtil.toTree(categoryToCategoryEx(list));
    }

    /**
     * 删除当前栏
     *
     * @param integer
     */
    @Override
    public void deleteCategory(Integer integer) {
        mapper.deleteByPrimaryKey(integer);
    }

    /**
     * 更新
     *
     * @param integer
     * @param category
     */
    @Override
    public void updateCategory(Integer integer, MallCategory category) {
        MallCategory primaryKey = mapper.selectByPrimaryKey(integer);
        if (primaryKey == null) throw new SystemException("分类不存在");
        primaryKey.setCategoryName(category.getCategoryName());
        primaryKey.setCategoryDesc(category.getCategoryDesc());
        primaryKey.setCategoryParentId(category.getCategoryParentId());
        primaryKey.setCategoryOrder(category.getCategoryOrder());
        mapper.updateByPrimaryKey(primaryKey);
    }

    /**
     * 增加分类
     *
     * @param category
     */
    @Override
    public void addCategory(MallCategory category) {
        category.setStatus((byte) 0);//正常
        category.setCreateTime(new Date());
        mapper.insert(category);
    }

    @Override
    public MallCategory gainMallCategoryById(Integer cateid) {
        return mapper.selectByPrimaryKey(cateid);
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
