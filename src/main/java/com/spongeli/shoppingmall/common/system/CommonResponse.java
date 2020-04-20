package com.spongeli.shoppingmall.common.system;

import com.spongeli.shoppingmall.common.cont.SystemConstant;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:32
 **/
public class CommonResponse {
    private int status = SystemConstant.SUCCESS;
    private String msg;
    private Object data;

    public CommonResponse(){
        this.data = "ok";
    }

    public CommonResponse(int status, String errMsg, Object data) {
        this.status = status;
        this.msg = errMsg;
        this.data = data;
    }

    public CommonResponse(String errMsg){
        this.status = SystemConstant.FAIL;
        this.msg = errMsg;
    }
    public CommonResponse(Object data){
        this.status = SystemConstant.SUCCESS;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
