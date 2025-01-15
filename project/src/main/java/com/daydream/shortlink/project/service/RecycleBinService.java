package com.daydream.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import com.daydream.shortlink.project.dto.req.RecycleBinSaveReqDTO;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:20
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}
