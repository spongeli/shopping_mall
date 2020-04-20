package com.spongeli.shoppingmall.service.manager.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.bean.MallGoodsEx;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.cont.SystemConstant;
import com.spongeli.shoppingmall.entity.request.goods.AddGoodsInparam;
import com.spongeli.shoppingmall.entity.request.goods.GainGoodsListInparam;
import com.spongeli.shoppingmall.entity.response.goods.GainGoodByIdResponse;
import com.spongeli.shoppingmall.pojo.dao.MallCateParamsMapper;
import com.spongeli.shoppingmall.pojo.dao.MallCategoryMapper;
import com.spongeli.shoppingmall.pojo.dao.MallGoodsMapper;
import com.spongeli.shoppingmall.pojo.model.*;
import com.spongeli.shoppingmall.service.manager.GoodsService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    @Autowired
    private MallCateParamsMapper paramsMapper;

    /**
     * 查询商品列表
     *
     * @param isOnline
     * @param inparam
     * @return
     */
    @Override
    public PageInfo<MallGoodsEx> gainGoodsList(boolean isOnline, GainGoodsListInparam inparam) {
        String orderby = "goods_id asc";

        if (StringUtils.isNotEmpty(inparam.getOrderRule())) {
            // 排序规则<> 1=综合排序&2=销量排序&3=价格排序（倒序）&4=价格排序（顺序）
            switch (inparam.getOrderRule()) {
                case GainGoodsListInparam.ORDER_RULE_2:
                    orderby = "sales_count desc";
                    break;
                case GainGoodsListInparam.ORDER_RULE_3:
                    orderby = "goods_price desc";
                    break;
                case GainGoodsListInparam.ORDER_RULE_4:
                    orderby = "goods_price asc";
                    break;
                default:
                    orderby = "scan_count desc";
            }
        } else {
            orderby = "scan_count asc";
        }


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

        MallGoodsExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(inparam.getCateId()) && inparam.getCateId() != -1) {
            criteria.andCateIdEqualTo(inparam.getCateId());
        }

        // 只查上线的
        if (isOnline) {
//            MallGoodsExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsStatusEqualTo(SystemConstant.YES);
        }
        List<MallGoods> goods = mapper.selectByExample(example);
        return new PageInfo<>(zhMallGoods(goods));
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
        goods.setStaticsParam(JSON.toJSONString(inparam.getStaticsParam()));
        goods.setDynamicParam(JSON.toJSONString(inparam.getDynamicParam()));
        goods.setServiceParam(JSON.toJSONString(inparam.getServiceParam()));
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
        goods.setStaticsParam(JSON.toJSONString(inparam.getStaticsParam()));
        goods.setDynamicParam(JSON.toJSONString(inparam.getDynamicParam()));
        goods.setServiceParam(JSON.toJSONString(inparam.getServiceParam()));
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

    /**
     * 通过关键字搜索
     *
     * @param keyword
     * @return
     */
    @Override
    public List<MallGoodsEx> queryByKeyword(String keyword) {
        MallGoodsExample example = new MallGoodsExample();
        MallGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameLike("%" + keyword + "%");
        MallGoodsExample.Criteria criteria1 = example.createCriteria();
        criteria1.andGoodsHotsLabelLike("%" + keyword + "%");
        example.or(criteria1);
        MallGoodsExample.Criteria criteria2 = example.createCriteria();
        criteria1.andCateNameLike("%" + keyword + "%");
        example.or(criteria2);
        return zhMallGoods(mapper.selectByExample(example));
    }

    private List<MallGoodsEx> zhMallGoods(List<MallGoods> list) {
        List<MallGoodsEx> goodsExes = new ArrayList<>();
        list.stream().forEach(item -> {
            goodsExes.add(zhMallGood(item));
        });
        return goodsExes;
    }

    /**
     * 转换成数组
     *
     * @param item
     * @return
     */
    private MallGoodsEx zhMallGood(MallGoods item) {
        MallGoodsEx ex = new MallGoodsEx();
        BeanUtils.copyProperties(item, ex);
        ex.setDynamicParamList(JSON.parseArray(item.getDynamicParam(), Integer.class));
        ex.setServiceParamList(JSON.parseArray(item.getServiceParam(), Integer.class));
        ex.setStaticsParamList(JSON.parseArray(item.getStaticsParam(), Integer.class));
        return ex;
    }

    @Override
    public GainGoodByIdResponse GainGoodById(Integer goodId) {
        GainGoodByIdResponse response = new GainGoodByIdResponse();

        // 商品信息
        MallGoodsEx goods = zhMallGood(validGoodsExist(goodId));

        // 类别信息
        // 动态属性
        List<MallCateParams> dynamicParams = null;
        if (!CollectionUtils.isEmpty(goods.getDynamicParamList())) {
            MallCateParamsExample example = new MallCateParamsExample();
            example.createCriteria().andAttrIdIn(goods.getDynamicParamList());
            dynamicParams = paramsMapper.selectByExample(example);
        }

        // 服务信息
        List<MallCateParams> servicesParams = null;
        if (!CollectionUtils.isEmpty(goods.getDynamicParamList())) {
            MallCateParamsExample example2 = new MallCateParamsExample();
            example2.createCriteria().andAttrIdIn(goods.getServiceParamList());
            servicesParams = paramsMapper.selectByExample(example2);
        }


        // 静态属性
        List<MallCateParams> staticsParams = null;
        if (!CollectionUtils.isEmpty(goods.getStaticsParamList())) {
            MallCateParamsExample example3 = new MallCateParamsExample();
            example3.createCriteria().andAttrIdIn(goods.getStaticsParamList());
            staticsParams = paramsMapper.selectByExample(example3);
        }

        response.setGoods(goods);
        response.setStaticsCates(staticsParams);
        response.setDynamicCates(dynamicParams);
        response.setServiceCates(servicesParams);
        return response;
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
