package com.spongeli.shoppingmall.service.web;

import com.spongeli.shoppingmall.common.bean.PageHeplerInparam;
import com.spongeli.shoppingmall.entity.request.card.AddCardInparam;

public interface CardService {
    void addCard(AddCardInparam inparam);

    Object GainCardList(PageHeplerInparam inparam);

    void updateCardNumber(Integer id, Integer number);

    void deleteCard(Integer id);
}
