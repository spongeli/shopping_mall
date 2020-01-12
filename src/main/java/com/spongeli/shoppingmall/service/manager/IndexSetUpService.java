package com.spongeli.shoppingmall.service.manager;

import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.entity.request.index.IndexSetUpInparam;
import com.spongeli.shoppingmall.entity.request.index.UpdateIndexSetUpInparam;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/12 9:13
 **/
public interface IndexSetUpService {
    JSONObject gainIndexSetUpList(String scope);

    void addIndexSetUp(IndexSetUpInparam inparam);

    void updateIndexSetUp(Integer id, UpdateIndexSetUpInparam inparam);

    void delete(Integer id);
}
