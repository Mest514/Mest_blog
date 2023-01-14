package com.mest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-11 17:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TagListDto {
    private Long id;
    private String name;
    private String remark;

}
