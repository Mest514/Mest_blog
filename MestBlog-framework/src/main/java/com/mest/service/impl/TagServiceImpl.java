package com.mest.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mest.domain.ResponseResult;
import com.mest.domain.dto.TagListDto;
import com.mest.domain.entity.Tag;
import com.mest.domain.entity.User;
import com.mest.domain.entity.UserLogin;
import com.mest.domain.vo.PageVo;
import com.mest.domain.vo.TagVo;
import com.mest.enums.AppHttpCodeEnum;
import com.mest.exception.SystemException;
import com.mest.mapper.TagMapper;
import com.mest.service.TagService;
import com.mest.utils.BeanCopyUtils;
import com.mest.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-01-08 11:30:59
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    @Override
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        //分页查询
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(tagListDto.getName()), Tag::getName, tagListDto.getName());
        queryWrapper.like(StringUtils.hasText(tagListDto.getRemark()), Tag::getRemark, tagListDto.getRemark());

        Page<Tag> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据
        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult<TagListDto> addTag(TagListDto tagListDto) {
        //非空判断
        if (!StringUtils.hasText(tagListDto.getName())) {
            throw new SystemException(AppHttpCodeEnum.TAGNAME_NOT_NULL);
        }
        //判断标签是否已存在
        if (tagExist(tagListDto.getName())) {
            throw new SystemException(AppHttpCodeEnum.TAGNAME_EXIST);
        }

        Tag tag = BeanCopyUtils.copyBean(tagListDto, Tag.class);
        //通过userId获取到对应的用户 将对应用户id存入CreateBy
        UserLogin loginUser = SecurityUtils.getLoginUser();

//        if (!StringUtils.isEmpty(tag.getCreateTime())) {
//            tag.setUpdateBy(loginUser.getUser().getId());
//        }
        tag.setCreateTime(new Date(System.currentTimeMillis()));
        tag.setCreateBy(String.valueOf(loginUser.getUser().getId()));
        save(tag);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult deleteTag(List<Long> id) {
        removeByIds(id);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult<TagListDto> getTag(Long id) {
        Tag tag = getById(id);
        return ResponseResult.okResult(tag);
    }

    @Override
    public List<TagVo> listAllTag() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId, Tag::getName);
        List<Tag> list = list(queryWrapper);
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(list, TagVo.class);
        return tagVos;
    }

//    @Override
//    public ResponseResult confirm(TagListDto tagListDto) {
////        Tag tag = new Tag();
////        tag.setName(tagListDto.getName());
////        tag.setRemark(tagListDto.getRemark());
////        UserLogin loginUser = SecurityUtils.getLoginUser();
////        tag.setUpdateBy(loginUser.getUser().getId());
////        tag.setUpdateTime(new Date(System.currentTimeMillis()));
//
//
//        return ResponseResult.okResult();
//    }


    private boolean tagExist(String name) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getName, name);
        return count(queryWrapper) > 0;
    }
}


