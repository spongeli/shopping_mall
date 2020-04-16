package com.spongeli.shoppingmall.common.system;

import com.github.pagehelper.PageHelper;
import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.common.bean.RequestMallUSerBean;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:22
 **/
public class BaseService {
    @Autowired
    protected RedisUtil redisUtil;
    // 获取当前用户信息
    protected RequestMallUSerBean getCurrentUser(){
        return RequestHolder.getCurrentUser();
    }

    // 获取当前用户信息的登陆token
    protected String getCurrentUserToken(){
        return RequestHolder.getCurrentUser().getToken();
    }

    // 设置分页信息
    protected void setPageStartPage(PageHeplerInparam inparam){
        setPageStartPage(inparam,"create_time asc");
    }

    // 设置分页信息
    protected void setPageStartPage(PageHeplerInparam inparam,String orderby){
        PageHelper.startPage(inparam.getPageCurrentPage(), inparam.getPageSize(), orderby);
    }
}
