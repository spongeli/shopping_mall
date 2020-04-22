package com.spongeli.shoppingmall.entity.request.address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddAddressInparam {
    @NotNull(message = "城市不能为空")
    private String addressCity;
    @NotNull(message = "详细地址不能为空")
    private String addressDetail;
    @NotNull(message = "收货人姓名不能为空")
    private String contacts;
    @NotNull(message = "收货人电话不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式有误")
    private String contactsPhone;

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }
}
