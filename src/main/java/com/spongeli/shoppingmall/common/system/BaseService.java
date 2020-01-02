package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:22
 **/
@Service
public class BaseService {
    @Autowired
    private RedisUtil redisUtil;

}
