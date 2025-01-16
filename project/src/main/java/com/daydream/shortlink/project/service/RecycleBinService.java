package com.daydream.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import com.daydream.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.daydream.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:20
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);
}
