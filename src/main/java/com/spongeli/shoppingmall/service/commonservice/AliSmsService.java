package com.spongeli.shoppingmall.service.commonservice;

import java.util.Map;

public interface AliSmsService {
    boolean sendAliSmsService(String phone, Map<String,String> param);
}
