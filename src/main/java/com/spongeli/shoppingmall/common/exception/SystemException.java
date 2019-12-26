package com.spongeli.shoppingmall.common.exception;

public class SystemException extends RuntimeException  {
    private String message;

    public SystemException() {
    }

    public SystemException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
