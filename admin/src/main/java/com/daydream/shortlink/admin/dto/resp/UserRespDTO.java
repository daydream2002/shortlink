package com.daydream.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2024/12/31 15:24
 */
@Data
public class UserRespDTO {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

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
