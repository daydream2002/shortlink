package com.daydream.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import com.daydream.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * Author daydream
 * Description
 * Date 2025/1/10 16:12
 */
public interface ShortLinkService extends IService<ShortLinkDO> {


    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO shortLinkCreateReqDTO);
}
