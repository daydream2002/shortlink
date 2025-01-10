package com.daydream.shortlink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import com.daydream.shortlink.project.dao.mapper.ShortLinkMapper;
import com.daydream.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.daydream.shortlink.project.service.ShortLinkService;
import com.daydream.shortlink.project.toolkit.HashUtil;
import org.springframework.stereotype.Service;

/**
 * Author daydream
 * Description
 * Date 2025/1/10 16:15
 */
@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO shortLinkCreateReqDTO) {
        String shortLinkSuffix = generateSuffix(shortLinkCreateReqDTO);
        ShortLinkDO shortLinkDO = BeanUtil.toBean(shortLinkCreateReqDTO, ShortLinkDO.class);
        shortLinkDO.setShortUri(shortLinkSuffix);
        shortLinkDO.setEnableStatus(0);
        shortLinkDO.setFullShortUrl(shortLinkCreateReqDTO.getDomain() + "/" + shortLinkSuffix);
        save(shortLinkDO);
        return ShortLinkCreateRespDTO
                .builder()
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .originUrl(shortLinkDO.getOriginUrl())
                .gid(shortLinkDO.getGid())
                .build();
    }

    private String generateSuffix(ShortLinkCreateReqDTO shortLinkCreateReqDTO) {
        String originUrl = shortLinkCreateReqDTO.getOriginUrl();
        return HashUtil.hashToBase62(originUrl);
    }
}
