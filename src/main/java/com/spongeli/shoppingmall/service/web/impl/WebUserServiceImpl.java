package com.spongeli.shoppingmall.service.web.impl;

import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.config.ManagerUserHandlerInterceptor;
import com.spongeli.shoppingmall.entity.request.user.WebDoLoginInparam;
import com.spongeli.shoppingmall.pojo.dao.ShoppingUserMapper;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;
import com.spongeli.shoppingmall.service.web.WebUserService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:59
 **/
@Service
public class WebUserServiceImpl extends WebBaseService implements WebUserService {

    private static final Logger logger = LogManager.getLogger(ManagerUserHandlerInterceptor.class);

    @Autowired
    private ShoppingUserMapper mapper;

    /**
     * 微信授权获取 昵称和pic
     * @param inparam
     * @return
     */
    @Override
    public Object wxlogin(WebDoLoginInparam inparam) {

        ShoppingUserEx currentUser = getCurrentUser();
        logger.info(currentUser);

        // 更新数据库
        ShoppingUser user = new ShoppingUser();
        user.setUserId(currentUser.getUserId());
        user.setNickname(inparam.getNickname());
        user.setUserpic(inparam.getUserpic());
        mapper.updateByPrimaryKeySelective(user);

        // 更新缓存
        currentUser.setNickname(inparam.getNickname());
        currentUser.setUserpic(inparam.getUserpic());
        redisUtil.set(getCurrentUserToken(), currentUser);
        return mapper.selectByPrimaryKey(currentUser.getUserId());
    }
}
