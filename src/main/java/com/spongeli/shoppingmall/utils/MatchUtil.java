package com.spongeli.shoppingmall.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/20 10:20
 **/
public class MatchUtil {
    /**
     * 判断是不是手机号
     *
     * @param phone
     * @return
     */
    public static boolean isMobileNO(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 是不是邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 全是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 身份证验证
     * @param idcard
     * @return
     */
    public static boolean isIdCard(String idcard) {
        Pattern idNumPattern = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        // 通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(idcard);
        // 判断用户输入是否为身份证号
        return idNumMatcher.matches();
    }

    /**
     * 密码必须是字母和数字的组合
     * @param password
     * @return
     */
    public static boolean isPassword(String password){
        Pattern idNumPattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$");
        // 通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(password);
        return idNumMatcher.matches();
    }
}
