package com.spongeli.shoppingmall.controller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.manager.MallUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWordController extends BaseController {
    private static final Logger logger = LogManager.getLogger(HelloWordController.class);
    @Autowired
    private MallUserService service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/all")
    public CommonResponse helloWord() {
        logger.info("你好：{}", "log4j2");
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        return instanceSuccess(service.query());
    }
}
