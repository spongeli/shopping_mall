package com.spongeli.shoppingmall.common.system;


import com.alibaba.fastjson.JSONObject;

public class BaseController {

    protected CommonResponse instanceSuccess() {
        return new CommonResponse();
    }

    protected CommonResponse instanceSuccess(Object obj) {
        return new CommonResponse(obj);
    }

    protected CommonResponse instanceSuccess(String key, Object values) {
        JSONObject object = new JSONObject();
        object.put(key, values);
        return new CommonResponse(object);
    }

    protected CommonResponse instanceFail(String msg) {
        return new CommonResponse(SystemConstant.FAIL, msg, null);
    }
}
