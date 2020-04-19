package com.spongeli.shoppingmall.service.commonservice;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.spongeli.shoppingmall.common.project.SmsConstant;
import com.spongeli.shoppingmall.controller.commoncontroller.SmsController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AliSmsServiceImpl implements AliSmsService {
    private static final Logger logger = LogManager.getLogger(AliSmsServiceImpl.class);

    /**
     * 发送短信服务
     *
     * @param phone 待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
     * @param param
     * @return
     */
    @Override
    public boolean sendAliSmsService(String phone, Map<String, String> param) {
        boolean bool = false;
        DefaultProfile profile = DefaultProfile.getProfile("default", SmsConstant.ACCESSKEYID, SmsConstant.ACCESSKEYSECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(SmsConstant.DOMAIN);
        request.setVersion(SmsConstant.VERSION);
        request.setAction(SmsConstant.ACTION);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        request.putQueryParameter("PhoneNumbers", phone);
        // 阿里云控制台签名
        request.putQueryParameter("SignName", SmsConstant.SIGNNAME);
        // 阿里云控制台模板编号
        request.putQueryParameter("TemplateCode", SmsConstant.TEMPLATECODE);
        // 充填的参数
        request.putQueryParameter("TemplateParam", JSON.toJSONString(param));
        try {
            logger.info("调用阿里云短信服务请求 phone={}，templateCode={},templateParam={}", phone, param);
            CommonResponse response = client.getCommonResponse(request);
            logger.info("调用阿里云短信服务请求结束：{}", response);
            // 下面是一个json格式转换工具，把String 转换为map 也可以转换为对象
            JSONObject jsonObject = JSON.parseObject(response.getData());
            if ("OK".equals(jsonObject.get("Code"))) {
                bool = true;
            }
        } catch (ServerException e) {
            logger.error("阿里云短信服务异常:{}", e);
        } catch (ClientException e) {
            logger.error("连接阿里云短信异常:{}", e);
        } catch (Exception e) {
            logger.error("json转换异常:{}", e);
        }
        return false;
    }
}
