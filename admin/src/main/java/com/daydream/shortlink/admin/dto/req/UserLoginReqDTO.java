package com.daydream.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Author daydream
 * Description 用户登录请求参数
 * Date 2025/1/9 11:18
 */
@Data
public class UserLoginReqDTO {
    private String username;
    private String password;
}
