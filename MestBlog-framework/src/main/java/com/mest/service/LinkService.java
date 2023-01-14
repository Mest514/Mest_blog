package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-12-29 17:11:38
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLinks();
}
