package com.spongeli.shoppingmall.common.system;

import com.github.pagehelper.PageHelper;
import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected RedisUtil redisUtil;

    // 设置分页信息
    protected void setPageStartPage(PageHeplerInparam inparam){
        setPageStartPage(inparam,"create_time asc");
    }

    // 设置分页信息
    protected void setPageStartPage(PageHeplerInparam inparam,String orderby){
        PageHelper.startPage(inparam.getPageCurrentPage(), inparam.getPageSize(), orderby);
    }
}
