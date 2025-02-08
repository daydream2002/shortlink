package com.daydream.shortlink.project.dto.req;

import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2025/2/8 20:50
 */
@Data
public class ShortLinkGroupStatsReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
