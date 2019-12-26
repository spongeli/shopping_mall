package com.spongeli.shoppingmall.controller.commoncontroller;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/12/26 9:45
 **/
@RestController
@RequestMapping("/upload")
public class FileUploadController extends BaseController {
    /**
     * @param file 要上传的图片
     * @return
     */
    @RequestMapping("/img")
    @ResponseBody
    public CommonResponse upload(@RequestParam("img") MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            // 上传
            return instanceSuccess(file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("上传文件【" + file.getOriginalFilename() + "】失败!");
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
