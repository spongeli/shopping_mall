package com.spongeli.shoppingmall.utils;

import java.util.Objects;

public class StringUtils {
    /**
     * 字符串不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    /**
     * 字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEquals(String str1, String str2) {
        return Objects.equals(str1, str2);
    }


}
