package com.spongeli.shoppingmall.common.exception;

import com.spongeli.shoppingmall.common.system.SystemConstant;

public class SystemException extends RuntimeException {
    private String message;
    private int status = SystemConstant.FAIL;

    public SystemException(String message) {
        this.message = message;
    }

    public SystemException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
