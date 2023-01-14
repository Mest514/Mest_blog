package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-29 17:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkVo {
    private String address;
    private String description;
    private String logo;
    private String name;
    private Long id;
}
