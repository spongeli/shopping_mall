package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.entity.response.user.DoLoginOutparam;
import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.MallUserExample;
import com.spongeli.shoppingmall.service.manager.MallUserService;
import com.spongeli.shoppingmall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:48
 **/
@Service
public class MallUserServiceImpl implements MallUserService {

    @Autowired
    private MallUserMapper mapper;
    @Autowired
    private RedisUtil redisUtil;
    @Value("${mall.login.key}")
    private String pwdkey;
    @Valid
    private String tokenkey;

    @Override
    public List<MallUser> query() {
        return null;
    }

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
        redisUtil.set(token, user, 60 * 60 * 2);
        DoLoginOutparam outparam = new DoLoginOutparam();
        outparam.setToken(token);
        outparam.setUser(users.get(0));
        return outparam;
    }
}
