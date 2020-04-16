package com.spongeli.shoppingmall.service.manager.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.entity.request.cate.AddCateAttrInparam;
import com.spongeli.shoppingmall.entity.request.cate.UdateCateParamInparam;
import com.spongeli.shoppingmall.entity.request.common.CommonInparam;
import com.spongeli.shoppingmall.pojo.dao.MallCateParamsMapper;
import com.spongeli.shoppingmall.pojo.model.MallCateParams;
import com.spongeli.shoppingmall.pojo.model.MallCateParamsExample;
import com.spongeli.shoppingmall.service.manager.CateAttrParamService;
import com.spongeli.shoppingmall.utils.StringUtils;
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
     *
     * @param type
     * @param inparam
     * @return
     */
    @Override
    public Object gainCateAttrParam(String type, CommonInparam inparam) {
        String orderby = "create_time asc";
        if(inparam.getQueryAll()){
            setPageStartPage(inparam.getPageInparam(), orderby);
        }
        MallCateParamsExample example = new MallCateParamsExample();
        MallCateParamsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(orderby);
        criteria.andAttrTypeEqualTo(type);
        if (StringUtils.isNotEmpty(inparam.getSearch())) {
            criteria.andAttrNameLike("%" + inparam.getSearch() + "%");
        }
        if(inparam.getQueryAll()){
           return mapper.selectByExample(example);
        }
        return new PageInfo<MallCateParams>(mapper.selectByExample(example));

    }

    /**
     * 增加属性
     *
     * @param params
     */
    @Override
    @Transactional
    public void addCateAttr(AddCateAttrInparam params) {
        MallCateParams cateParams = new MallCateParams();
        BeanUtils.copyProperties(params, cateParams);
        cateParams.setCreateTime(new Date());
        if (StringUtils.isEquals(params.getAttrType(), "service")) {
            cateParams.setAttrValue(cateParams.getAttrName());
        }
        mapper.insertSelective(cateParams);
    }

    /**
     * 增加属性的参数
     *
     * @param attrId
     * @param param
     */
    @Override
    @Transactional
    public void addCateAttrParam(Integer attrId, String param) {
        MallCateParams cateParams = mapper.selectByPrimaryKey(attrId);
        if (Objects.isNull(cateParams)) throw new SystemException("属性【" + attrId + "】不存在");
        cateParams.setAttrValue(param);
        mapper.updateByPrimaryKey(cateParams);
    }

    /**
     * 删除熟悉
     *
     * @param attrId
     */
    @Override
    @Transactional
    public void deleteCateParam(Integer attrId) {
        mapper.deleteByPrimaryKey(attrId);
    }

    /**
     * 更新 名称或者状态
     *
     * @param attrId
     * @param inparam
     */
    @Override
    @Transactional
    public void updateCateParam(Integer attrId, UdateCateParamInparam inparam) {
        MallCateParams param = new MallCateParams();
        param.setAttrId(attrId);
        BeanUtils.copyProperties(inparam, param);
        mapper.updateByPrimaryKeySelective(param);

    }
}
