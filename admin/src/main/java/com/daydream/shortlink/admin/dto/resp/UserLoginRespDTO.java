package com.daydream.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author daydream
 * Description 用户登录返回相应token
 * Date 2025/1/9 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    /**
     * 用户token
     */
    private String token;
}
