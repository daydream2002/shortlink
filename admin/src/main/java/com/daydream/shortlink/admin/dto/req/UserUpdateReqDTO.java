package com.daydream.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2025/1/8 15:04
 */
@Data
public class UserUpdateReqDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

}
