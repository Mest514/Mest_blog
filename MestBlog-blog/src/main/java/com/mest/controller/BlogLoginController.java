package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.entity.User;
import com.mest.enums.AppHttpCodeEnum;
import com.mest.exception.SystemException;
import com.mest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-29 19:55
 **/
@RestController
public class BlogLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    private ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return userService.login(user);
    }

    @PostMapping("logout")
    private ResponseResult logout() {
      return  userService.logout();
    }

}
