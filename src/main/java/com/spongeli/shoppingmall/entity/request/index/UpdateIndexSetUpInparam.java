package com.spongeli.shoppingmall.entity.request.index;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/12 9:46
 **/
public class UpdateIndexSetUpInparam {
    // 上架状态
    private Byte status;
    // 是否可点击状态
    private Byte clickStatus;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getClickStatus() {
        return clickStatus;
    }

    public void setClickStatus(Byte clickStatus) {
        this.clickStatus = clickStatus;
    }
}
