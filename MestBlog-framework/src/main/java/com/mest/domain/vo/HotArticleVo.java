package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MestBlog
 * @description: 响应给前端的字段
 * @author: Mest
 * @create: 2022-12-27 16:54
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    private Long id;
    private String title;
    private Long viewCount;
}
