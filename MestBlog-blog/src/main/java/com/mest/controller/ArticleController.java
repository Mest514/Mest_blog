package com.mest.controller;


import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Article;
import com.mest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2022-12-18 11:03:40
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("list")
    public List<Article> test() {
        return articleService.list();
    }

    @GetMapping("hotArticleList")
    public ResponseResult hotArticleList() {
        //查询热门文章，然后封装成ResponseResult对象返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    //分页
    @GetMapping("articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }

    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id) {
        return articleService.updateViewCount(id);
    }
}

