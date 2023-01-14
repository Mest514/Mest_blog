package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.dto.AddArticleDto;
import com.mest.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);


    ResponseResult add(AddArticleDto article);
}
