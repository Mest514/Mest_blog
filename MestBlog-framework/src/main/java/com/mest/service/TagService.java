package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.dto.TagListDto;
import com.mest.domain.entity.Tag;
import com.mest.domain.vo.PageVo;
import com.mest.domain.vo.TagVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-01-08 11:30:59
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    ResponseResult<TagListDto> addTag(TagListDto tagListDto);

    ResponseResult deleteTag(List<Long> id);

    ResponseResult<TagListDto> getTag(Long id);

    List<TagVo> listAllTag();

//    ResponseResult confirm(TagListDto tagListDto);
}
