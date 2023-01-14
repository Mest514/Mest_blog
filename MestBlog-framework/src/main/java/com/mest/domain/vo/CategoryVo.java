package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-27 20:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {
    private Long id;
    private String name;
    //描述
    private String description;

}
