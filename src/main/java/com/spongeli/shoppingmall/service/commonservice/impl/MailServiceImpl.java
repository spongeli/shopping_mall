package com.spongeli.shoppingmall.service.commonservice.impl;

import com.spongeli.shoppingmall.service.commonservice.MailService;
import com.spongeli.shoppingmall.service.web.impl.WxServiceImpl;
import com.spongeli.shoppingmall.utils.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailServiceImpl implements MailService {

    private static final Logger logger = LogManager.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    // 注入常量
    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 发送文本邮件
     *
     * @param toAddr
     * @param title
     * @param content
     */
    @Override
    public void sendTextMail(String toAddr, String title, String content) {
        // 纯文本邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toAddr);
        message.setSubject(title);
        message.setText(content);

        try {
            mailSender.send(message);
            logger.info("Text邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送Text邮件时发生异常！", e);
        }

    }

    /**
     * 发送html邮件
     *
     * @param toAddr
     * @param title
     * @param content
     */
    @Override
    public boolean sendHtmlMail(String toAddr, String title, String content) {
        // html 邮件对象
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个 multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
            return true;
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
            return false;
        }

    }


    /**
     * 发送带附件的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String toAddr, String title, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //helper.addAttachment("test"+fileName, file);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }


    /**
     * 发送正文中有静态资源（图片）的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceMail(String toAddr, String title, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }

    /**
     * 发送验证码
     *
     * @param destEmail 发送到的邮箱
     * @param code      验证码
     */
    @Override
    public boolean sendEmailByVerify(String destEmail, String code) {
        if (StringUtils.isEmpty(destEmail)) {
            return false;
        }
        Context context = new Context();
        context.setVariable("code", code);
        // 传递 emailTemplate.html 模板需要的值，并将模板转换为 String
        String emailContent = templateEngine.process("emailTemplate", context);
        return sendHtmlMail(destEmail, "验证码", emailContent);
    }
}