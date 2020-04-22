package com.spongeli.shoppingmall.service.web;

import com.spongeli.shoppingmall.entity.request.address.AddAddressInparam;

public interface AddressService {
    void addAddress(AddAddressInparam inparam);

    Object gainUserAddresss();

    void updateAddress(Integer id, AddAddressInparam inparam);

    void deleteAddress(Integer id);

    void defaultAddress(Integer id);
}
