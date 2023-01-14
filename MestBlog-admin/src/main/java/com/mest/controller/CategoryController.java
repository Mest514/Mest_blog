package com.mest.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Category;
import com.mest.domain.vo.CategoryVo;
import com.mest.domain.vo.ExcelCategoryVo;
import com.mest.domain.vo.PageVo;
import com.mest.enums.AppHttpCodeEnum;
import com.mest.service.CategoryService;
import com.mest.utils.BeanCopyUtils;
import com.mest.utils.WebUtils;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @program: MestBlog
 * @description: 后台分类接口
 * @author: Mest
 * @create: 2023-01-12 20:52
 **/
@RestController
@RequestMapping("/content/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 后台查询所有分类接口
     */
    @GetMapping("/listAllCategory")
    private ResponseResult listAllCategory() {
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    /**
     * 后台展示所有分类
     */
    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVos = categoryService.selectCategoryPage(category, pageNum, pageSize);
        return ResponseResult.okResult(pageVos);
    }


    /**
     * 下载导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        //设置下载文件的请求头
        try {
            WebUtils.setDownLoadHeader("分类.xlsx", response);
            //获取需要导入的数据
            List<Category> categoryVos = categoryService.list();
            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(categoryVos, ExcelCategoryVo.class);

            //把数据写入到Excel中
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class)
                    .autoCloseStream(Boolean.FALSE).sheet("分类导出")
                    .doWrite(excelCategoryVos);

        } catch (Exception e) {
            //如果出现错误也要响应json数据
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            WebUtils.renderString(response, JSON.toJSONString(result));

        }


    }
}
