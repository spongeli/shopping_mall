package com.spongeli.shoppingmall.service.web.impl;

import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.entity.request.card.AddCardInparam;
import com.spongeli.shoppingmall.pojo.dao.MallCardMapper;
import com.spongeli.shoppingmall.pojo.model.MallCard;
import com.spongeli.shoppingmall.service.web.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class CardServiceImpl extends WebBaseService implements CardService {

    @Autowired
    private MallCardMapper mapper;

    /**
     * 添加购物车
     *
     * @param inparam
     * @return
     */
    @Override
    public void addCard(AddCardInparam inparam) {

        MallCard record = mapper.selectByPrimaryKey(inparam.getGoodsId(), getCurrentUserId());
        if (Objects.isNull(record)) {
            record = new MallCard();
            record.setCreateTime(new Date());
            record.setGoodId(inparam.getGoodsId());
            record.setNumber(inparam.getNumber());
            record.setUserid(getCurrentUserId());
            mapper.insert(record);
        } else {
            MallCard card = new MallCard();
            card.setNumber(record.getNumber() + 1);
            card.setGoodId(inparam.getGoodsId());
            card.setUserid(getCurrentUserId());
            mapper.updateByPrimaryKeySelective(card);
        }
    }
}
