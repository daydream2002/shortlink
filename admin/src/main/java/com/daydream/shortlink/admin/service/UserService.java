package com.daydream.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.admin.dao.entity.UserDO;
import com.daydream.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.daydream.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.daydream.shortlink.admin.dto.resp.UserRespDTO;

/**
 * Author daydream
 * Description
 * Date 2024/12/31 15:14
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);
    /**
     * 判断用户名是否存在
     * @param username
     * @return 用户名存在返回true, 不存在返回false
     */
    Boolean hasUsername(String username);
    /**
     * 用户注册
     * @param userRegisterReqDTO
     */
    void register(UserRegisterReqDTO userRegisterReqDTO);

    void update(UserUpdateReqDTO userUpdateReqDTO);
}
