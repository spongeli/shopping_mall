package com.spongeli.shoppingmall.service.manager;

import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.entity.request.order.GainOrderListInparam;
import com.spongeli.shoppingmall.pojo.model.MallOrder;

public interface OrderService {
    PageInfo<MallOrder> gainOrderList(GainOrderListInparam inparam);
}
