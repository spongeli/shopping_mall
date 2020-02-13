package com.spongeli.shoppingmall.common.system;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:07
 **/
public interface SystemConstant {
    // 返回状态码
    int SUCCESS = 200;
    int FAIL = 400;
    int LOGIN_EXPIRE = 300; // 登陆过期


    // ftp 服务器相关
    String FTP_ADDRESS = "47.104.69.239";
    int FTP_PORT = 21;
    String FTP_USERNAME = "lichao";
    String FTP_PASSWORD = "lichao666";

    // 系统常量相关
    String QUERY_ALL = "all";
    String QUERY_PART = "part";

    Byte YES = (byte)0;
    Byte NO = (byte)1;

    String CATE_DYNAMIC = "dynamic";
    String CATE_STATICS = "statics";
}
