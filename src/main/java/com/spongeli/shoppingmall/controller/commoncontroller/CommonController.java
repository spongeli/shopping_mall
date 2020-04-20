package com.spongeli.shoppingmall.controller.commoncontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import com.spongeli.shoppingmall.common.util.ServiceUtil;
import com.spongeli.shoppingmall.common.util.VerifyCode;
import com.spongeli.shoppingmall.service.commonservice.CommonService;
import com.spongeli.shoppingmall.service.commonservice.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {


    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CommonService commonService;

    /* 获取验证码图片*/
    @GetMapping("/verify_code")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //生成对应宽高的初始图片
            String randomText = VerifyCode.drawRandomText(width, height, verifyImg);
            // 保存到redis 临时验证码
            redisUtil.set(ServiceUtil.getIpAddr(request), randomText, 60 * 10);

            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
            OutputStream os = response.getOutputStream(); //获取文件输出流
            ImageIO.write(verifyImg, "png", os);//输出图片流
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/uuid")
    public CommonResponse gainRedisUUID(){
        return instanceSuccess(commonService.genOrderNoByRedis("tcb"));
    }
}
