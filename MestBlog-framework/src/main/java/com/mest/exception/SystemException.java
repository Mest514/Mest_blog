package com.mest.exception;

import com.mest.enums.AppHttpCodeEnum;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-30 17:13
 **/
public class SystemException extends RuntimeException{
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}
