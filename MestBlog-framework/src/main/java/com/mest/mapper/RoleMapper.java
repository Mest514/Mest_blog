package com.mest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mest.domain.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-09 15:45:01
 */
public interface RoleMapper extends BaseMapper<Role> {
//通过userId查询角色信息

    @Select("    SELECT r.role_key\n" +
            "            FROM\n" +
            "    sys_user_role as ur\n" +
            "    LEFT JOIN sys_role as r ON ur.role_id=r.id\n" +
            "            WHERE\n" +
            "    user_id=#{userId} AND\n" +
            "    r.`status`=0 AND\n" +
            "    r.del_flag=0")
    List<String> selectRoleKeyByUserId(Long userId);
}
