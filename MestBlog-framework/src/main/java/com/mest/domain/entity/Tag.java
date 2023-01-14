package com.mest.domain.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2023-01-08 11:30:58
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sg_tag")
public class Tag implements Serializable {
    @TableId
    private Long id;
    //标签名@TableId
    private String name;
    private String createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）@TableId
    private Integer delFlag;
    //备注@TableId
    private String remark;
}

