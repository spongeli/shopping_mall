package com.spongeli.shoppingmall.service.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.common.CommonInparam;
import com.spongeli.shoppingmall.pojo.dao.MallGoodsServicesMapper;
import com.spongeli.shoppingmall.pojo.model.MallGoodsServices;
import com.spongeli.shoppingmall.pojo.model.MallGoodsServicesExample;
import com.spongeli.shoppingmall.service.manager.ServiceConfigService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class ServiceConfigServiceImpl extends BaseService implements ServiceConfigService {

    @Autowired
    private MallGoodsServicesMapper mapper;

    @Override
    public PageInfo gainServiceConfigList(CommonInparam inparam) {
        String orderby = "create_time asc";
        PageHelper.startPage(inparam.getPageInparam().getPageCurrentPage(), inparam.getPageInparam().getPageSize(), orderby);
        MallGoodsServicesExample example = new MallGoodsServicesExample();
        example.setOrderByClause(orderby);
        MallGoodsServicesExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(inparam.getSearch())) {
            criteria.andServiceNameLike("%" + inparam.getSearch() + "%");
        }
        List<MallGoodsServices> mallGoodsServices = mapper.selectByExample(example);
        return new PageInfo<>(mallGoodsServices);
    }

    /**
     * 添加配置
     * @param services
     */
    @Override
    public void addServiceConfig(MallGoodsServices services) {
        services.setStatus((byte)0);
        services.setCreateTime(new Date());
        mapper.insert(services);
    }
}
