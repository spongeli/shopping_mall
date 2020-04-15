package com.spongeli.shoppingmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.manager.MallUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import sun.net.www.HeaderParser;


@RestController
public class HelloWordController extends BaseController {
    private static final Logger logger = LogManager.getLogger(HelloWordController.class);
    @Autowired
    private MallUserService service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/mall")
    public CommonResponse helloWord() {
        logger.info("你好：{}", "log4j2");
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        return instanceSuccess(service.query());
    }

    @GetMapping("/check")
    public CommonResponse check(@RequestBody JSONObject param) throws NoHandlerFoundException {
        logger.info("鉴权服务器：{}", param);
        // 保存字符串
        throw new NoHandlerFoundException("POST","check",new HttpHeaders());
    }
}
