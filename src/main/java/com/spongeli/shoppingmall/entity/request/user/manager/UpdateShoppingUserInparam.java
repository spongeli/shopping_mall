package com.spongeli.shoppingmall.entity.request.user.manager;

import javax.validation.constraints.NotEmpty;

public class UpdateShoppingUserInparam {
    @NotEmpty(message = "用户状态不能为空")
    private Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
