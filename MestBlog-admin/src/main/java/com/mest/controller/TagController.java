package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.dto.TagListDto;
import com.mest.domain.entity.Tag;
import com.mest.domain.entity.UserLogin;
import com.mest.domain.vo.PageVo;
import com.mest.domain.vo.TagVo;
import com.mest.service.TagService;
import com.mest.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: MestBlog
 * @description: 标签
 * @author: Mest
 * @create: 2023-01-08 11:35
 **/
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

//    @GetMapping("list")
//    public ResponseResult list() {
//        return ResponseResult.okResult(tagService.list());
//    }

    @GetMapping("list")
    private ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }

    /**
     * 标签管理新增接口
     */
    @PostMapping()
    private ResponseResult<TagListDto> addTag(@RequestBody TagListDto tagListDto) {
        return tagService.addTag(tagListDto);
    }

    /**
     * 标签管理删除接口
     **/
    @DeleteMapping("/{id}")
    private ResponseResult deleteTag(@PathVariable("id") List<Long> id) {
        return tagService.deleteTag(id);
    }

    /**
     * 标签管理修改-查询接口
     */
    @GetMapping("/{id}")
    private ResponseResult<TagListDto> getTag(@PathVariable("id") Long id) {
        return tagService.getTag(id);
    }

    /**
     * 标签管理修改-保存接口
     */
//    @PutMapping()
//    private ResponseResult confirm(@RequestBody TagListDto tagListDto) {
//        return tagService.confirm(tagListDto);
//    }
    @PutMapping()
    private ResponseResult confirm(@RequestBody Tag tag) {
        UserLogin loginUser = SecurityUtils.getLoginUser();
        tag.setUpdateBy(loginUser.getUser().getId());
        tag.setUpdateTime(new Date(System.currentTimeMillis()));
        return ResponseResult.okResult(tagService.updateById(tag));
    }

    /**
     * 查询所有标签接口
     */
    @GetMapping("/listAllTag")
    private ResponseResult listAllTag() {
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}
