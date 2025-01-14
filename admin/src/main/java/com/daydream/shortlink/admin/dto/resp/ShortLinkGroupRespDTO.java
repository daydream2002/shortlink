package com.daydream.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * Author daydream
 * Description 短链接分组
 * Date 2025/1/9 19:49
 */
@Data
public class ShortLinkGroupRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;
    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 分组下短链接数量
     */
    private Integer shortLinkCount;
}
