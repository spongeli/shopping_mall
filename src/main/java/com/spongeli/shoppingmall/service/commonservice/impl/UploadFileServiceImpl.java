package com.spongeli.shoppingmall.service.commonservice.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.service.commonservice.UploadFileService;
import com.spongeli.shoppingmall.utils.FtpFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class UploadFileServiceImpl extends BaseService implements UploadFileService {

    private static String filePath = "D:\\dev_soft\\windows\\nginx-1.9.15\\nginx-1.9.15\\html\\upload\\";
//    private static String filePath = "D:\\software\\nginx-1.17.1\\html\\upload\\";
    private static String imgPath = "http://127.0.0.1:9000/upload/";

    @Override
    public String uploadImg(MultipartFile file) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = file.getInputStream();
//            FtpFileUtil.uploadFile(file.getOriginalFilename(),inputStream);
            // 上传
            String originalFilename = file.getOriginalFilename();
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + substring;
            File tempFile = new File(filePath + fileName);
            outputStream = new FileOutputStream(tempFile);
            byte[] arr = new byte[1024];
            int len;
            while ((len = inputStream.read(arr)) > 0) {
                outputStream.write(arr, 0, len);
            }

            return imgPath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("上传文件【" + file.getOriginalFilename() + "】失败!");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
