package com.spongeli.shoppingmall.service.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.user.manager.GainShoppingUsersInparam;
import com.spongeli.shoppingmall.entity.request.user.manager.UpdateShoppingUserInparam;
import com.spongeli.shoppingmall.pojo.dao.ShoppingUserMapper;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;
import com.spongeli.shoppingmall.pojo.model.ShoppingUserExample;
import com.spongeli.shoppingmall.service.manager.ConsumerService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消费者服务
 */
@Service
public class ConsumerServiceImpl extends BaseService implements ConsumerService {

    private static final Logger logger = LogManager.getLogger(ConsumerServiceImpl.class);

    @Autowired
    private ShoppingUserMapper mapper;

    /**
     * 获取用户列表
     * @param inparam
     * @return
     */
    @Override
    public PageInfo<ShoppingUser> gainShoppingUsers(GainShoppingUsersInparam inparam) {
        String orderby = "user_id desc";
        PageHelper.startPage(inparam.getPageInparam().getPageCurrentPage(), inparam.getPageInparam().getPageSize(), orderby);
        ShoppingUserExample example = new ShoppingUserExample();
        example.setOrderByClause(orderby);
        if (StringUtils.isNotEmpty(inparam.getSearch())) {
            ShoppingUserExample.Criteria criteria = example.createCriteria();
            criteria.andNicknameLike("%" + inparam.getSearch() + "%");
            ShoppingUserExample.Criteria criteria1 = example.createCriteria();
            criteria1.andPhoneLike("%"+inparam.getSearch()+"%");
            example.or(criteria1);
        }
        List<ShoppingUser> users = mapper.selectByExample(example);
        return new PageInfo<>(users);
    }

    /**
     * 修改用户的数据
     * @param userid
     * @param inparam
     */
    @Override
    public void updateShoppingUser(Integer userid, UpdateShoppingUserInparam inparam) {
        ShoppingUser user =new ShoppingUser();
        user.setStatus(inparam.getStatus());
        user.setUserId(userid);
        mapper.updateByPrimaryKeySelective(user);
    }
}
