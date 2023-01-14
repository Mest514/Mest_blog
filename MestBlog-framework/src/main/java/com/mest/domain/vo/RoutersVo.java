package com.mest.domain.vo;

import com.mest.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-10 20:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutersVo {
    private List<Menu> menus;

}
