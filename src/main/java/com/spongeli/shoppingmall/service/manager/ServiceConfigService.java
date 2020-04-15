package com.spongeli.shoppingmall.service.manager;

import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.entity.request.common.CommonInparam;
import com.spongeli.shoppingmall.pojo.model.MallGoodsServices;

public interface ServiceConfigService {
    PageInfo gainServiceConfigList(CommonInparam search);

    void addServiceConfig(MallGoodsServices services);
}
