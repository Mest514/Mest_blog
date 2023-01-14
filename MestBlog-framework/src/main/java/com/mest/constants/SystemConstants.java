package com.mest.constants;

/**
 * @program: MestBlog
 * @description: 字面值常量
 * @author: Mest
 * @create: 2022-12-27 17:52
 **/
public class SystemConstants {
    /**
     * 文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     * 文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final String STATUS_NORMAL = "0";

    /**
     * @Description: 友情链接常量
     * @Param:
     * @return:
     * @Author: mest
     * @Date: 2022/12/29
     */
    public static final String LINK_STATUS_NORMAL = "0";
    public static final String ROOT_ID = "-1";

    /**
     * 评论类型为：文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     * 评论类型为：友联评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 文章浏览量key
     */
    public static final String ARTICLE_VIEWCOUNT = "article:viewCount";

    /**
     * 菜单类型：菜单类型（M目录 C菜单 F按钮）
     */
    public static final String MENU = "C";
    public static final String BUTTON = "F";

    /**
     * 后台用户
     **/
    public static final String ADMIN = "1";
}
