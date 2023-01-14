package com.mest.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-30 10:14
 **/

@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;


}
