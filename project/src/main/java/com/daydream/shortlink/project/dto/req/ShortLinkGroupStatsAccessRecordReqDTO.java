package com.daydream.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.project.dao.entity.LinkAccessLogsDO;
import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2025/2/8 21:08
 */
@Data
public class ShortLinkGroupStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {

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
