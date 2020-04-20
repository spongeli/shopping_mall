package com.spongeli.shoppingmall.service.web.impl;

import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.cont.MallConstant;
import com.spongeli.shoppingmall.common.cont.SystemConstant;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.config.ManagerUserHandlerInterceptor;
import com.spongeli.shoppingmall.entity.request.user.web.DoLoginPwdInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoRegisterInparam;
import com.spongeli.shoppingmall.entity.request.user.web.WebDoLoginInparam;
import com.spongeli.shoppingmall.pojo.dao.ShoppingUserMapper;
import com.spongeli.shoppingmall.pojo.model.ShoppingUser;
import com.spongeli.shoppingmall.pojo.model.ShoppingUserExample;
import com.spongeli.shoppingmall.service.commonservice.CommonService;
import com.spongeli.shoppingmall.service.web.WebUserService;
import com.spongeli.shoppingmall.utils.MD5Util;
import com.spongeli.shoppingmall.utils.MatchUtil;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:59
 **/
@Service
public class WebUserServiceImpl extends WebBaseService implements WebUserService {
    private static final Logger logger = LogManager.getLogger(ManagerUserHandlerInterceptor.class);

    @Value("mall.user.login.key")
    private String loginKey;

    @Autowired
    private ShoppingUserMapper mapper;
    @Autowired
    private CommonService commonService;

    /**
     * 微信授权获取 昵称和pic
     *
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

    /**
     * 用户注册接口
     * 密码用【mall.user.login.key】加密
     *
     * @param inparam
     */
    @Override
    public void doRegister(DoRegisterInparam inparam) {
        // 验证表单数据数据
        checkPwd(inparam);

        // 验证注册数据
        if (!Objects.isNull(checkShopping(inparam.getUsername()))) {
            throw new SystemException("当前手机号或邮箱已注册，请前往登陆");
        }

        // 添加用户信息
        ShoppingUser user = new ShoppingUser();
        if (MatchUtil.isMobileNO(inparam.getUsername())) {
            user.setPhone(inparam.getUsername());
        } else {
            user.setEmail(inparam.getUsername());
        }
        user.setPassword(MD5Util.getMD5(inparam.getPassword() + "-" + loginKey));
        user.setLoginLastTime(new Date());
        user.setCreateTime(new Date());
        user.setStatus(SystemConstant.YES);
        user.setNickname(commonService.genOrderNoByRedis(MallConstant.DEFAULTUSERPREFIX));
        mapper.insert(user);
    }

    /**
     * 用户密码登录
     *
     * @param inparam
     * @return
     */
    @Override
    public Object doLoginByPwd(DoLoginPwdInparam inparam) {
        String redisKey = getCurrentIp() + "-login-num";

        // 验证多次登陆限制
        Object countNum = redisUtil.get(redisKey);
        int count = Objects.isNull(countNum) ? 0 : Integer.valueOf(String.valueOf(countNum));
        if (count >= 3) {
            throw new SystemException("密码登陆错误次数过多，请24小时后重试，或联系管理员");
        }
        redisUtil.set(redisKey, ++count, 60 * 60 * 24);

        ShoppingUser user = checkShopping(inparam.getUsername());
        if (Objects.isNull(user)) {
            throw new SystemException("用户不存在！");
        }

        if (!StringUtils.isEquals(user.getPassword(), MD5Util.getMD5(inparam.getPassword() + "-" + loginKey))) {
            throw new SystemException("密码错误！");
        }

        // 更新最后登录时间
        updateUserLastLoginTime(user);
        redisUtil.del(redisKey);
        String tempToken = MD5Util.getMD5(inparam.getUsername() + "-" + loginKey);
//        存缓存
        redisUtil.set(tempToken, user);
        JSONObject json = new JSONObject();
        json.put("token", tempToken);
        json.put("userinfo", user);
        return json;
    }

    private void updateUserLastLoginTime(ShoppingUser shoppingUser) {
        ShoppingUser record = new ShoppingUser();
        record.setUserId(shoppingUser.getUserId());
        record.setLoginLastTime(new Date());
        mapper.updateByPrimaryKeySelective(record);
    }

    private ShoppingUser checkShopping(String username) {
        ShoppingUserExample example = new ShoppingUserExample();
        ShoppingUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(username);
        ShoppingUserExample.Criteria criteria1 = example.createCriteria();
        criteria1.andEmailEqualTo(username);
        example.or(criteria1);
        List<ShoppingUser> shoppingUsers = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(shoppingUsers)) {
            return null;
        }
        return shoppingUsers.get(0);
    }


    private void checkPwd(DoRegisterInparam inparam) {
        if (!StringUtils.isEquals(inparam.getPassword(), inparam.getPassword2())) {
            throw new SystemException("两次密码不一致");
        }
    }
}
