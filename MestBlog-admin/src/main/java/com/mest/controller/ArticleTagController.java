package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.dto.AddArticleDto;
import com.mest.service.ArticleService;
import com.mest.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: MestBlog
 * @description: 后台admin文章接口
 * @author: Mest
 * @create: 2023-01-13 12:05
 **/
@RestController
@RequestMapping("/content/article")
public class ArticleTagController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article) {
        return articleService.add(article);
    }
}
