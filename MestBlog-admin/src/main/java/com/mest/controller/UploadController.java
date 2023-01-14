package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: MestBlog
 * @description: 后台上传图片接口
 * @author: Mest
 * @create: 2023-01-12 21:37
 **/
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("upload")
    private ResponseResult uploadImg(@RequestParam("img") MultipartFile multipartFile) {
        try {
            return uploadService.uploadImg(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传上传失败");
        }
    }
}
