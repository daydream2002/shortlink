package com.daydream.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 10:50
 */
public interface recycleBinService {
    Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
