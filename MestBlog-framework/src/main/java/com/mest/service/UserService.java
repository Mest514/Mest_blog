package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-12-29 20:03:58
 */
public interface UserService extends IService<User> {

    ResponseResult login(User user);

    ResponseResult logout();
}
