package com.spongeli.shoppingmall.controller.commoncontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.commonservice.AliSmsService;
import com.spongeli.shoppingmall.service.commonservice.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    private String receptionMailAddr = "552489109@qq.com";

    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MailService mailService;
    @Autowired
    private AliSmsService service;

    // 发送邮件
    @GetMapping("/send_email")
    public CommonResponse sendEmail() {
//        mailService.sendTextMail(receptionMailAddr,"测试","我发送了哦");

        //创建邮件正文
        Context context = new Context();
//        context.setVariable("type", "登录");
//        context.setVariable("code","123456");
        Map<String, Object> map = new HashMap<>();
        map.put("type", "登录");
        map.put("code", "123456");
        context.setVariables(map);
        // 传递 emailTemplate.html 模板需要的值，并将模板转换为 String
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(receptionMailAddr, "主题：这是模板邮件", emailContent);
        return instanceSuccess();
    }

    @GetMapping("send_sms")
    public CommonResponse sendSms() {
        Map<String, String> param = new HashMap<>();
        param.put("code", "123456");
        service.sendAliSmsService("17600484122", param);
        return instanceSuccess();
    }
}
