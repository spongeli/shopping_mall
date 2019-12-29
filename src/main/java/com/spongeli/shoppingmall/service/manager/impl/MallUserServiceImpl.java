package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.entity.request.user.DoLoginInparam;
import com.spongeli.shoppingmall.entity.response.user.DoLoginOutparam;
import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.pojo.model.MallUserExample;
import com.spongeli.shoppingmall.service.manager.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:48
 **/
@Service
public class MallUserServiceImpl implements MallUserService {

    @Autowired
    private MallUserMapper mapper;

    @Value("${mall.login.key}")
    private String md5Key;


    @Override
    public List<MallUser> query() {
        return null;
    }

    @Override
    public DoLoginOutparam doLogin(DoLoginInparam inparam) {
        MallUserExample example = new MallUserExample();
        example.createCriteria().andUsernameEqualTo(inparam.getUsername()).andPasswordEqualTo(inparam.getPassword());
        List<MallUser> users = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users)){
            throw new SystemException("用户明或密码错误");
        }
        DoLoginOutparam outparam = new DoLoginOutparam();

        return null;
    }
}
