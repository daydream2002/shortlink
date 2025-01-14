package com.daydream.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import com.daydream.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2025/1/10 16:12
 */
public interface ShortLinkService extends IService<ShortLinkDO> {


    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO shortLinkCreateReqDTO);

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    void updateShortLink(ShortLinkUpdateReqDTO requestParam);
}
