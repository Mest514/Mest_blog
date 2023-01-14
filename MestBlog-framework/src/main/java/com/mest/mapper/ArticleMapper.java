package com.mest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mest.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表(Article)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-17 21:18:44
 */
public interface ArticleMapper extends BaseMapper<Article> {

}

