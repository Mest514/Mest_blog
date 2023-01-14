package com.mest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mest.domain.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 菜单权 限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-09 12:03:28
 */

public interface MenuMapper extends BaseMapper<Menu> {
//##通过用户id查询到对应的perms
//##1、先通过user_role表,用户id查询到对应的角色id
//##2、用角色id去查询对应的menu_id
//##3、用menu_id去对应perms


    @Select("SELECT DISTINCT m.perms\n" +
            "from sys_user_role AS ur\n" +
            "LEFT JOIN  sys_role_menu AS rm ON ur.role_id=rm.role_id\n" +
            "LEFT JOIN sys_menu AS m ON rm.menu_id=m.id\n" +
            "WHERE \n" +
            "ur.user_id=#{userId} AND\n" +
            "m.`menu_type`IN('C','F') AND\n" +
            "m.`status`=0 AND\n" +
            "m.`del_flag`=0")
    List<String> selectPermsByUserId(Long userId);

    @Select("        SELECT\n" +
            "          DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status, IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time\n" +
            "        FROM\n" +
            "            `sys_menu` m\n" +
            "        WHERE\n" +
            "            m.`menu_type` IN ('C','M') AND\n" +
            "            m.`status` = 0 AND\n" +
            "            m.`del_flag` = 0\n" +
            "        ORDER BY\n" +
            "            m.parent_id,m.order_num")
    List<Menu> selectAllRouterMenu();

    @Select(" SELECT\n" +
            "          DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status, IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time\n" +
            "        FROM\n" +
            "            `sys_user_role` ur\n" +
            "            LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`\n" +
            "            LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`\n" +
            "        WHERE\n" +
            "            ur.`user_id` = #{userId} AND\n" +
            "            m.`menu_type` IN ('C','M') AND\n" +
            "            m.`status` = 0 AND\n" +
            "            m.`del_flag` = 0\n" +
            "        ORDER BY\n" +
            "            m.parent_id,m.order_num")
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
}
