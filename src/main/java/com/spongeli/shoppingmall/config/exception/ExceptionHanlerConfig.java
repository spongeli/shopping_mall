package com.spongeli.shoppingmall.config.exception;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHanlerConfig {
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public CommonResponse exceptionHandler(SystemException e){
        return new CommonResponse(e.getMessage());
    }
}
