package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-12 21:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVo {
    private Long id;
    private String name;//标签名

}
