package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.entity.request.user.UpdateShoppingUserInparam;
import com.spongeli.shoppingmall.entity.response.user.DoLoginOutparam;
import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.MallUserExample;
import com.spongeli.shoppingmall.service.manager.MallUserService;
import com.spongeli.shoppingmall.utils.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ 管理员服务
 * @Author spongeli
 * @Date 2019/12/26 9:48
 **/
@Service
public class MallUserServiceImpl extends BaseService implements MallUserService {

    private static final Logger logger = LogManager.getLogger(MallUserServiceImpl.class);

    @Autowired
    private MallUserMapper mapper;
    @Autowired
    private RedisUtil redisUtil;
    @Value("${mall.login.key}")
    private String pwdkey;
    @Value("mall.token.key")
    private String tokenkey;

    @Override
    public List<MallUser> query() {
        return null;
    }

    /**
     * 管理员登陆
     *
     * @param inparam
     * @return
     */
    @Override
    public DoLoginOutparam doLogin(DoLoginInparam inparam) {
        MallUserExample example = new MallUserExample();
        String password = MD5Util.getMD5(pwdkey + "-" + inparam.getPassword());
        example.createCriteria().andUsernameEqualTo(inparam.getUsername()).andPasswordEqualTo(password);
        List<MallUser> users = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users) || users.size() != 1) {
            throw new SystemException("用户名或密码错误");
        }
        MallUser user = users.get(0);
        if (user.getStatus() != 0) {
            throw new SystemException("当前账户异常，请联系管理员！");
        }
        String token = MD5Util.getMD5(inparam.getUsername() + '-' + tokenkey);
        // 存入缓存
        redisUtil.set(token, user, 60 * 30);
        DoLoginOutparam outparam = new DoLoginOutparam();
        outparam.setToken(token);
        outparam.setUser(users.get(0));
        return outparam;
    }

    /**
     * 退出登录
     */
    @Override
    public void outLogin() {
        // 删除缓存
        redisUtil.del(getCurrentUserToken());
    }

}
