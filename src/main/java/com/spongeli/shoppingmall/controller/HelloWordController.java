package com.spongeli.shoppingmall.controller;

import com.spongeli.shoppingmall.pojo.dao.MallUserMapper;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class HelloWordController {
    @Autowired
    private MallUserMapper userDao;

    @GetMapping("/hello")
     public void helloWord(){
        List<MallUser> mallUsers = userDao.selectAll();
        System.out.println(mallUsers);
    }
}
