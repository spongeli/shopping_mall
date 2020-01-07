package com.spongeli.shoppingmall.config.exception;

import com.spongeli.shoppingmall.common.system.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice
public class UnexpectedTypeExceptionHnadler {
    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    public CommonResponse exceptionHandler(UnexpectedTypeException e){
        System.err.println(e.getMessage());
        return new CommonResponse("系统繁忙，请联系管理员");
    }
}
