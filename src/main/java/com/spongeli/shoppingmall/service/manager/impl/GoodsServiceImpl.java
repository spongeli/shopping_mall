package com.spongeli.shoppingmall.service.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.goods.AddGoodsInparam;
import com.spongeli.shoppingmall.entity.request.goods.GainGoodsListInparam;
import com.spongeli.shoppingmall.pojo.dao.MallCategoryMapper;
import com.spongeli.shoppingmall.pojo.dao.MallGoodsMapper;
import com.spongeli.shoppingmall.pojo.model.*;
import com.spongeli.shoppingmall.service.manager.GoodsService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 商品管理servie
 */
@Service
public class GoodsServiceImpl extends BaseService implements GoodsService {
    @Autowired
    private MallGoodsMapper mapper;
    @Autowired
    private MallCategoryMapper categoryMapper;

    /**
     * 查询商品列表
     *
     * @param inparam
     * @return
     */
    @Override
    public PageInfo<MallGoods> gainGoodsList(GainGoodsListInparam inparam) {
        String orderby = "goods_id asc";
        PageHelper.startPage(inparam.getPageInparam().getPageCurrentPage(), inparam.getPageInparam().getPageSize(), orderby);
        MallGoodsExample example = new MallGoodsExample();
        example.setOrderByClause(orderby);
        if (StringUtils.isNotEmpty(inparam.getSearch())) {
            MallGoodsExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsNameLike("%" + inparam.getSearch() + "%");
            MallGoodsExample.Criteria criteria1 = example.createCriteria();
            criteria1.andGoodsHotsLabelLike("%" + inparam.getSearch() + "%");
            example.or(criteria1);
            MallGoodsExample.Criteria criteria2 = example.createCriteria();
            criteria1.andCateNameLike("%" + inparam.getSearch() + "%");
            example.or(criteria2);
        }
        List<MallGoods> goods = mapper.selectByExample(example);
        return new PageInfo<>(goods);
    }

    /**
     * 商品添加
     *
     * @param inparam
     * @return
     */
    @Override
    public void addGoods(AddGoodsInparam inparam) {
        MallGoods goods = new MallGoods();
        BeanUtils.copyProperties(inparam, goods);
        goods.setGoodsStatus((byte) 1); // 默认不上架
        goods.setCreateTime(new Date());
        // 设置属性名称
        goods.setCateName(attrNameById(inparam.getCateId()));
        mapper.insert(goods);
    }

    /**
     * 更新商品状态
     *
     * @param goodId
     * @param status
     */
    @Override
    public void updateGoodsStatus(Integer goodId, Byte status) {
        validGoodsExist(goodId);
        MallGoods record = new MallGoods();
        record.setGoodsId(goodId);
        record.setGoodsStatus(status);
        mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 更新其他属性
     *
     * @param goodIs
     * @param inparam
     */
    @Override
    public void updateGoodsInfo(Integer goodIs, AddGoodsInparam inparam) {
        MallGoods goods = validGoodsExist(goodIs);
        if (!Objects.equals(inparam.getCateId(), goods.getCateId())) {
            inparam.setCateName(attrNameById(inparam.getCateId()));
        }
        BeanUtils.copyProperties(inparam, goods);
        mapper.updateByPrimaryKey(goods);
    }

    /**
     * 删除商品
     *
     * @param goodId
     */
    @Override
    public void deleteGoods(Integer goodId) {
        validGoodsExist(goodId);
        mapper.deleteByPrimaryKey(goodId);
    }

    @Override
    public List<MallGoods> queryByKeyword(String keyword) {
        MallGoodsExample example = new MallGoodsExample();
        MallGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameLike("%" + keyword + "%");
        MallGoodsExample.Criteria criteria1 = example.createCriteria();
        criteria1.andGoodsHotsLabelLike("%" + keyword + "%");
        example.or(criteria1);
        MallGoodsExample.Criteria criteria2 = example.createCriteria();
        criteria1.andCateNameLike("%" + keyword + "%");
        example.or(criteria2);
        return mapper.selectByExample(example);
    }


    /**
     * 校验商品Id存在性
     *
     * @param goodId
     */
    private MallGoods validGoodsExist(Integer goodId) {
        MallGoods goods = mapper.selectByPrimaryKey(goodId);
        if (Objects.isNull(goods)) throw new SystemException("商品ID<<" + goodId + ">>不存在");
        return goods;
    }

    private String attrNameById(Integer attrId) {
        MallCategory category = categoryMapper.selectByPrimaryKey(attrId);
        if (Objects.isNull(category)) throw new SystemException("商品分类不存在");
        if (category.getStatus() == 1) throw new SystemException("商品分类状态异常");
        return category.getCategoryName();
    }
}
