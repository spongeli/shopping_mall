package com.spongeli.shoppingmall.service.web.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.common.bean.RequestMallUSerBean;
import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.common.wx.WxConstant;
import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.dao.ShoppingUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.MallUserExample;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;
import com.spongeli.shoppingmall.pojo.model.ShoppingUserExample;
import com.spongeli.shoppingmall.service.web.WxService;
import com.spongeli.shoppingmall.utils.HttpClientUtil;
import com.spongeli.shoppingmall.utils.MD5Util;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 9:38
 **/
@Service
public class WxServiceImpl extends WebBaseService implements WxService {
    private static final Logger logger = LogManager.getLogger(WxServiceImpl.class);

    @Value("mall.user.login.key")
    private String loginKey;

    @Autowired
    private ShoppingUserMapper mapper;

    @Override
    public JSONObject login(String token) {
        // 获取用户 openid {"session_key":"jD6iMEg58WvpBP2LnDZlXQ==","openid":"orhZe5UPLD68g0aPcTk0FijhkOKc"}
        JSONObject authInfo = geuAuthInfo(token);
        String openid = authInfo.getString("openid");

//        保存登陆信息
        ShoppingUser user = null;
        ShoppingUserExample example = new ShoppingUserExample();
        ShoppingUserExample.Criteria criteria = example.createCriteria();
        criteria.andWxOpenidEqualTo(openid);
        List<ShoppingUser> users = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users) || users.size() != 1) {
            // 用户第一次登陆
            user = saveShoppingUser(openid);
        } else {
            // 第二次登陆
            updateUserLastLoginTime(users.get(0));
            user = users.get(0);
        }

        ShoppingUserEx userEx = new ShoppingUserEx();
        BeanUtils.copyProperties(user, userEx);
        userEx.setSessionKey(authInfo.getString("session_key"));
        String tempToken = MD5Util.getMD5(openid + '-' + loginKey);
//        存缓存
        redisUtil.set(tempToken, userEx);
        JSONObject res = new JSONObject();
        res.put("token",tempToken);
        res.put("userinfo",user);
        return res;
    }

    private void updateUserLastLoginTime(ShoppingUser shoppingUser) {
        ShoppingUser record = new ShoppingUser();
        record.setUserId(shoppingUser.getUserId());
        record.setLoginLastTime(new Date());
        mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 用户第一次登陆 记录
     *
     * @param openid
     */
    private ShoppingUser saveShoppingUser(String openid) {
        ShoppingUser user = new ShoppingUser();
        user.setStatus(SystemConstant.YES);
        user.setWxOpenid(openid);
        user.setLoginLastTime(new Date());
        user.setCreateTime(new Date());
        mapper.insert(user);
        return user;
    }

    private JSONObject geuAuthInfo(String token) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", WxConstant.APPID);
        params.put("secret", WxConstant.APP_SECRET);
        params.put("grant_type", "authorization_code");
        params.put("js_code", token);

        String authString = HttpClientUtil.doGet(WxConstant.auth_url, params);
        if (StringUtils.isEmpty(authString)) {
            throw new SystemException("获取openid失败");
        }
        return JSON.parseObject(authString);
    }
}
