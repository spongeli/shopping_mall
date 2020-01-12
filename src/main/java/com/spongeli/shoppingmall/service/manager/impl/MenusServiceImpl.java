package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.bean.MallMenusEx;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.pojo.dao.MallMenusMapper;
import com.spongeli.shoppingmall.pojo.model.MallMenus;
import com.spongeli.shoppingmall.pojo.model.MallMenusExample;
import com.spongeli.shoppingmall.service.manager.MallMenusService;
import com.spongeli.shoppingmall.utils.common.TreeMenusUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/2 10:20
 **/
@Service
public class MenusServiceImpl extends BaseService implements MallMenusService {
    @Autowired
    private MallMenusMapper mapper;
    @Override
    public List<MallMenusEx> findAllMallMenus() {
        MallMenusExample example = new MallMenusExample();
        example.setOrderByClause("level desc");
        // 目前支持所有菜单
        List<MallMenus> menus = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(menus)) return new ArrayList<>();
        // 转换对象 并 获取菜单树,返回
        return TreeMenusUtil.toTree(menusToMenusEx(menus));
    }

















    private List<MallMenusEx> menusToMenusEx(List<MallMenus> menus) {
        List<MallMenusEx> list =  new ArrayList<>();
        menus.stream().forEach( item ->{
            MallMenusEx ex = new MallMenusEx();
            BeanUtils.copyProperties(item,ex);
            list.add(ex);
        });
        return list;
    }
}
