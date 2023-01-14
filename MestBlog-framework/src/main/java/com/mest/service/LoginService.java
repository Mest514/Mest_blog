package com.mest.service;

import com.mest.domain.ResponseResult;
import com.mest.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
