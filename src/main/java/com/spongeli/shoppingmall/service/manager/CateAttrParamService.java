package com.spongeli.shoppingmall.service.manager;

import com.spongeli.shoppingmall.entity.request.cate.AddCateAttrInparam;
import com.spongeli.shoppingmall.entity.request.cate.UdateCateParamInparam;
import com.spongeli.shoppingmall.entity.request.common.CommonInparam;
import com.spongeli.shoppingmall.pojo.model.MallCateParams;

import java.util.List;

public interface CateAttrParamService {
    Object gainCateAttrParam(String type, CommonInparam pageinfo);

    void addCateAttr(AddCateAttrInparam params);

    void addCateAttrParam(Integer attrId, String param);

    void deleteCateParam(Integer attrId);

    void updateCateParam(Integer attrId, UdateCateParamInparam inparam);
}
