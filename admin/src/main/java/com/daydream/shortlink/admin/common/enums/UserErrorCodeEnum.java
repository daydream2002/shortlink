package com.daydream.shortlink.admin.common.enums;

import com.daydream.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * Author daydream
 * Description
 * Date 2025/1/7 14:38
 */
public enum UserErrorCodeEnum implements IErrorCode {
    USER_NULL("B000200", "用户记录不存在"),
    USER_NAME_EXIST("B000201", "用户名已存在"),
    USER_EXIST("B000202", "用户记录已存在"),
    USER_SAVE_ERROR("B000203", "用户记录新增失败"),
    // ========== 二级宏观错误码 系统请求操作频繁 ==========
    FLOW_LIMIT_ERROR("A000300", "当前系统繁忙，请稍后再试");


    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
