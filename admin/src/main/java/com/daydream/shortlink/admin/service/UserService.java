package com.daydream.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.admin.dao.entity.UserDO;
import com.daydream.shortlink.admin.dto.resp.UserRespDTO;

/**
 * Author daydream
 * Description
 * Date 2024/12/31 15:14
 */
public interface UserService extends IService<UserDO> {
    UserRespDTO getUserByUsername(String username);
}
