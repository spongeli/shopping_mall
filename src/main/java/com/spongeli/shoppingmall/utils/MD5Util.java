package com.spongeli.shoppingmall.utils;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/11/8 14:39
 **/

import org.springframework.util.DigestUtils;


/**
 * MD5工具类
 *
 * @author pibigstar
 */
public class MD5Util {
    /**
     * 生成md5
     *
     * @param
     * @return
     */
    public static String getMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}



