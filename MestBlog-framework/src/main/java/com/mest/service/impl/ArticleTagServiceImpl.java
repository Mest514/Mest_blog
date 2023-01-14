package com.mest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mest.domain.ResponseResult;
import com.mest.domain.dto.AddArticleDto;
import com.mest.domain.entity.ArticleTag;
import com.mest.mapper.ArticleTagMapper;
import com.mest.service.ArticleTagService;
import com.mest.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章标签关联表(ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2023-01-13 14:15:21
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}

