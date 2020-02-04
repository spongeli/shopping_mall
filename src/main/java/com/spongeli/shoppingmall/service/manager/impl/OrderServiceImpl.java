package com.spongeli.shoppingmall.service.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.order.GainOrderListInparam;
import com.spongeli.shoppingmall.pojo.dao.MallOrderMapper;
import com.spongeli.shoppingmall.pojo.model.MallGoods;
import com.spongeli.shoppingmall.pojo.model.MallGoodsExample;
import com.spongeli.shoppingmall.pojo.model.MallOrder;
import com.spongeli.shoppingmall.pojo.model.MallOrderExample;
import com.spongeli.shoppingmall.service.manager.OrderService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/2/4 9:59
 **/
@Service
public class OrderServiceImpl extends BaseService implements OrderService {
    @Autowired
    private MallOrderMapper mapper;

    @Override
    public PageInfo<MallOrder> gainOrderList(GainOrderListInparam inparam) {
        String orderby = "create_time asc";
        PageHelper.startPage(inparam.getPageInparam().getPageCurrentPage(), inparam.getPageInparam().getPageSize(), orderby);
        MallOrderExample example = new MallOrderExample();
        example.setOrderByClause(orderby);
        if (StringUtils.isNotEmpty(inparam.getSearch())) {
            try {
                int orderid = Integer.valueOf(inparam.getSearch());
                MallOrderExample.Criteria criteria = example.createCriteria();
                criteria.andOrderIdEqualTo(orderid);
            }catch (Exception e){}
            MallOrderExample.Criteria criteria1 = example.createCriteria();
            criteria1.andGoodNameLike("%" + inparam.getSearch() + "%");
            example.or(criteria1);
        }
        List<MallOrder> goods = mapper.selectByExample(example);
        return new PageInfo<>(goods);
    }
}
