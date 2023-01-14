package com.mest.controller;

import com.mest.annotation.SystemLog;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Comment;
import com.mest.domain.entity.User;
import com.mest.service.CommentUserService;
import com.mest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-03 16:43
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommentUserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo() {
        return userService.userInfo();
    }

    @PutMapping("/userInfo")
    @SystemLog(businessName = "更新用户信息")
    public ResponseResult updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
