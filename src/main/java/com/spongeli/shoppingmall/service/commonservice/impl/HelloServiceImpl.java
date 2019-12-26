package com.spongeli.shoppingmall.service.commonservice.impl;

import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.service.commonservice.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:10
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private MallUserMapper userMapper;


}
