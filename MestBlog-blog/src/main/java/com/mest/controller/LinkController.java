package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: MestBlog
 * @description: 友情链接
 * @author: Mest
 * @create: 2022-12-29 17:06
 **/
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLinks() {
        return linkService.getAllLinks();
    }
}
