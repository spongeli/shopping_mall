package com.spongeli.shoppingmall.service.commonservice;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String uploadImg(MultipartFile file);
}
