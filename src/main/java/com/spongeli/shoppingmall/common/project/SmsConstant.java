package com.spongeli.shoppingmall.common.project;

/**
 * 短信服务
 */
public interface SmsConstant {

    // 阿里云的accessKeyId
    String ACCESSKEYID = "LTAIW6flbWkjg8hq";//你的accessKeyId,
    // 阿里云的accessKeyId
    String ACCESSKEYSECRET = "Vfpm4hqpUdW0aZ5AmPM6PjDp3xoOOs";//你的accessKeySecret
    // 阿里云的服务(固定)
    String DOMAIN = "dysmsapi.aliyuncs.com";
    // 版本号(固定)
    String VERSION = "2017-05-25";

    // 阿里云短信签名
    String SIGNNAME = "Crazy李";
    //    阿里云控制台模板编号
    String TEMPLATECODE = "SMS_187953840";
//    固定
    String ACTION = "SendSms";
}
