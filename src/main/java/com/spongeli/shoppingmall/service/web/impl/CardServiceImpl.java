package com.spongeli.shoppingmall.service.web.impl;

import com.github.pagehelper.PageInfo;
import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.WebBaseService;
import com.spongeli.shoppingmall.entity.request.card.AddCardInparam;
import com.spongeli.shoppingmall.entity.response.card.GainCardListResponse;
import com.spongeli.shoppingmall.pojo.dao.MallCardMapper;
import com.spongeli.shoppingmall.pojo.dao.MallGoodsMapper;
import com.spongeli.shoppingmall.pojo.dao.common.WebCardMapper;
import com.spongeli.shoppingmall.pojo.model.MallCard;
import com.spongeli.shoppingmall.pojo.model.MallCardExample;
import com.spongeli.shoppingmall.pojo.model.MallGoods;
import com.spongeli.shoppingmall.pojo.model.MallGoodsExample;
import com.spongeli.shoppingmall.service.web.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CardServiceImpl extends WebBaseService implements CardService {

    @Autowired
    private MallCardMapper mapper;
    @Autowired
    private WebCardMapper webCardMapper;
    @Autowired
    private MallGoodsMapper goodsMapper;

    /**
     * 添加购物车
     *
     * @param inparam
     * @return
     */
    @Override
    public void addCard(AddCardInparam inparam) {
        // 验证商品存在
        MallGoods mallGoods = goodsMapper.selectByPrimaryKey(inparam.getGoodsId());
        if (Objects.isNull(mallGoods)) {
            throw new SystemException("商品【" + inparam.getGoodsId() + "】不存在");
        }

        MallCardExample example = new MallCardExample();
        MallCardExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(getCurrentUserId()).andGoodIdEqualTo(inparam.getGoodsId()).andSelectStyleEqualTo(inparam.getSelectStyle());
        List<MallCard> mallCards = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(mallCards)) {
            MallCard record = new MallCard();
            record.setCreateTime(new Date());
            record.setGoodId(inparam.getGoodsId());
            record.setNumber(inparam.getNumber());
            record.setUserid(getCurrentUserId());
            record.setSelectStyle(inparam.getSelectStyle());
            mapper.insert(record);
        } else {
            MallCard card = new MallCard();
            int tempNumber = mallCards.get(0).getNumber() + 1;
            int number = tempNumber <= mallGoods.getGoodsCount() ? tempNumber : mallGoods.getGoodsCount();
            card.setNumber(number);
            card.setCardId(mallCards.get(0).getCardId());
            mapper.updateByPrimaryKeySelective(card);
        }
    }

    /**
     * 获取购物车列表
     *
     * @param inparam
     * @return
     */
    @Override
    public Object GainCardList(PageHeplerInparam inparam) {
        setPageStartPage(inparam);
        List<GainCardListResponse> listResponses = webCardMapper.gainCardListResponse(getCurrentUserId());
        return new PageInfo<>(listResponses);
    }

    /**
     * 更新购物车商品个数
     *
     * @param id
     * @param number
     */
    @Override
    public void updateCardNumber(Integer id, Integer number) {
        MallCard card = new MallCard();
        card.setCardId(id);
        card.setNumber(number);
        mapper.updateByPrimaryKeySelective(card);
    }

    @Override
    public void deleteCard(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
