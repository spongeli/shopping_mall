package com.spongeli.shoppingmall.entity.request.user.web;

import javax.validation.constraints.NotNull;

public class DoLoginVerifyInparam {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "验证码不能为空")
    private String verify;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
