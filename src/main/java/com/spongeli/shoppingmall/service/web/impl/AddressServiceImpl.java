package com.spongeli.shoppingmall.service.web.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.entity.request.address.AddAddressInparam;
import com.spongeli.shoppingmall.pojo.dao.MallUserAddressMapper;
import com.spongeli.shoppingmall.pojo.model.MallUserAddress;
import com.spongeli.shoppingmall.pojo.model.MallUserAddressExample;
import com.spongeli.shoppingmall.service.web.AddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl extends WebBaseService implements AddressService {
    private static final Logger logger = LogManager.getLogger(AddressServiceImpl.class);

    @Autowired
    private MallUserAddressMapper mapper;

    /**
     * 获取用户的地址列表
     *
     * @return
     */
    @Override
    public Object gainUserAddresss() {
        MallUserAddressExample example = new MallUserAddressExample();
        example.createCriteria().andUserIdEqualTo(getCurrentUserId());
        example.setOrderByClause(" address_status desc ");
        return mapper.selectByExample(example);
    }

    /**
     * 更新地址
     *
     * @param id
     * @param inparam
     */
    @Override
    public void updateAddress(Integer id, AddAddressInparam inparam) {
        MallUserAddress address = queryAddressById(id);
        BeanUtils.copyProperties(inparam, address);
        mapper.updateByPrimaryKey(address);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteAddress(Integer id) {
        queryAddressById(id);
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 设为默认
     *
     * @param id
     */
    @Override
    @Transactional
    public void defaultAddress(Integer id) {
        queryAddressById(id);
        MallUserAddress record = new MallUserAddress();
        record.setAddressStatus((byte)0);
        MallUserAddressExample example = new MallUserAddressExample();
        example.createCriteria().andAddressStatusEqualTo((byte)1);
        mapper.updateByExampleSelective(record,example);
        record.setId(id);
        record.setAddressStatus((byte)1);
        mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 增加地址
     *
     * @param inparam
     */
    @Override
    public void addAddress(AddAddressInparam inparam) {
        MallUserAddressExample example = new MallUserAddressExample();
        example.createCriteria().andUserIdEqualTo(getCurrentUserId());
        List<MallUserAddress> addresses = mapper.selectByExample(example);

        MallUserAddress record = new MallUserAddress();
        BeanUtils.copyProperties(inparam, record);
        record.setId(getCurrentUserId());
        record.setCreateTime(new Date());
        record.setAddressStatus(CollectionUtils.isEmpty(addresses) ? (byte) 1 : (byte) 0);
        mapper.insert(record);
    }


    private MallUserAddress queryAddressById(Integer id) {
        MallUserAddress mallUserAddress = mapper.selectByPrimaryKey(id);
        if (Objects.isNull(mallUserAddress)) {
            throw new SystemException("地址不存在【" + id + "】");
        }
        return mallUserAddress;
    }
}
