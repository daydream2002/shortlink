package com.daydream.shortlink.project.dto.resp;

/**
 * Author daydream
 * Description
 * Date 2025/1/14 15:42
 */

import lombok.Data;

/**
 * 短链接分组查询返回参数
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}

