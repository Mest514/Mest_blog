package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Menu;
import com.mest.domain.entity.User;
import com.mest.domain.entity.UserLogin;
import com.mest.domain.vo.AdminUserInfoVo;
import com.mest.domain.vo.RoutersVo;
import com.mest.domain.vo.UserInfoVo;
import com.mest.enums.AppHttpCodeEnum;
import com.mest.exception.SystemException;
import com.mest.service.LoginService;
import com.mest.service.MenuService;
import com.mest.service.RoleService;
import com.mest.service.UserService;
import com.mest.utils.BeanCopyUtils;
import com.mest.utils.RedisCache;
import com.mest.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 后台系统登录接口
 * @Param:
 * @return:
 * @Author: mest
 * @Date: 2023/1/8
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisCache redisCache;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    //后台getInfo接口
    @GetMapping("getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo() {
        //获取当前登录的用户信息
        UserLogin loginUser = SecurityUtils.getLoginUser();
        User user = loginUser.getUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(user.getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(user.getId());
        //封装数据返回
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms, roleKeyList, userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    //后台getRouters接口
    @GetMapping("getRouters")
    private ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getUserId();
        //查询menu结果是tree的形式
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        return ResponseResult.okResult(new RoutersVo(menus));
    }

    //后台注销功能
    @PostMapping("/user/logout")
    private ResponseResult logout() {
        return loginService.logout();
    }
}