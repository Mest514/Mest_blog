package com.mest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.User;
import com.mest.domain.entity.UserLogin;
import com.mest.domain.vo.BlogUserLoginVo;
import com.mest.domain.vo.UserInfoVo;
import com.mest.mapper.UserMapper;
import com.mest.service.UserService;
import com.mest.utils.BeanCopyUtils;
import com.mest.utils.JwtUtil;
import com.mest.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-12-29 20:03:59
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断认证是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid，生成token
        UserLogin loginUser = (UserLogin) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("bloglogin:" + userId, loginUser);
        //把token和userInfo 封装返回
        //把userInfo转换成userInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt, userInfoVo);

        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult logout() {

        //获取userid-》在token中获取，解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin loginUser = (UserLogin) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        //在redis中移除用户
        redisCache.deleteObject("bloglogin:"+userId);
        return ResponseResult.okResult();
    }
}

