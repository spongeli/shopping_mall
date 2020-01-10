package com.spongeli.shoppingmall.controller.commoncontroller;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.service.commonservice.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/manager/upload")
public class FileUploadController extends BaseController {

    @Autowired
    private UploadFileService service;

    /**
     * @param file 要上传的图片
     * @return
     */
    @RequestMapping("/img")
    @ResponseBody
    public CommonResponse upload(MultipartFile file) {
        return instanceSuccess("url", service.uploadImg(file));
    }
}
