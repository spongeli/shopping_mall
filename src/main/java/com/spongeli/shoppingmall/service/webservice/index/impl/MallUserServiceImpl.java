package com.spongeli.shoppingmall.service.webservice.index.impl;

import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.service.webservice.index.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<MallUser> query() {
        return mapper.selectAll();
    }
}
