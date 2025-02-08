package com.daydream.shortlink.project.service;

/**
 * Author daydream
 * Description
 * Date 2025/2/7 17:10
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.daydream.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
 /**
     * 获取分组短链接监控数据
     *
     * @param requestParam 获取分组短链接监控数据入参
     * @return 分组短链接监控数据
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

}
