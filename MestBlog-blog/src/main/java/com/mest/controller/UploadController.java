package com.mest.controller;

import com.aliyun.oss.model.MultipartUpload;
import com.mest.domain.ResponseResult;
import com.mest.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: MestBlog
 * @description: 文件上传
 * @author: Mest
 * @create: 2023-01-04 10:19
 **/
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("upload")
    private ResponseResult uploadImg(MultipartFile img) {
        return uploadService.uploadImg(img);
    }

}
