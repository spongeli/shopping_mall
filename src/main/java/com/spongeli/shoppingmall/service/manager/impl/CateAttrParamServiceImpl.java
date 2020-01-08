package com.spongeli.shoppingmall.service.manager.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.cate.AddCateAttrInparam;
import com.spongeli.shoppingmall.entity.request.cate.UdateCateParamInparam;
import com.spongeli.shoppingmall.pojo.dao.MallCateParamsMapper;
import com.spongeli.shoppingmall.pojo.model.MallCateParams;
import com.spongeli.shoppingmall.pojo.model.MallCateParamsExample;
import com.spongeli.shoppingmall.service.manager.CateAttrParamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CateAttrParamServiceImpl extends BaseService implements CateAttrParamService {
    @Autowired
    private MallCateParamsMapper mapper;

    /**
     * 获取分类参数
     * @param cateId
     * @param type
     * @return
     */
    @Override
    public List<MallCateParams> gainCateAttrParam(Integer cateId, String type) {
        MallCateParamsExample example = new MallCateParamsExample();
        example.createCriteria().andCateIdEqualTo(cateId).andAttrTypeEqualTo(type);
        return mapper.selectByExample(example);

    }

    /**
     * 增加属性
     * @param params
     */
    @Override
    @Transactional
    public void addCateAttr(AddCateAttrInparam params) {
        MallCateParams cateParams = new MallCateParams();
        BeanUtils.copyProperties(params,cateParams);
        cateParams.setCreateTime(new Date());
        mapper.insertSelective(cateParams);
    }

    /**
     * 增加属性的参数
     * @param attrId
     * @param param
     */
    @Override
    @Transactional
    public void addCateAttrParam(Integer attrId, String param) {
        MallCateParams cateParams = mapper.selectByPrimaryKey(attrId);
        if(Objects.isNull(cateParams)) throw new SystemException("属性【"+attrId+"】不存在");
        cateParams.setAttrList(param);
        mapper.updateByPrimaryKey(cateParams);
    }

    /**
     * 删除熟悉
     * @param attrId
     */
    @Override
    @Transactional
    public void deleteCateParam(Integer attrId) {
        mapper.deleteByPrimaryKey(attrId);
    }

    /**
     * 更新 名称或者状态
     * @param attrId
     * @param inparam
     */
    @Override
    @Transactional
    public void updateCateParam(Integer attrId, UdateCateParamInparam inparam) {
        MallCateParams param = new MallCateParams();
        param.setAttrId(attrId);
        BeanUtils.copyProperties(inparam,param);
        mapper.updateByPrimaryKeySelective(param);

    }
}
