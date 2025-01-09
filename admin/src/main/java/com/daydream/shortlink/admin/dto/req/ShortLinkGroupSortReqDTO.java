package com.daydream.shortlink.admin.dto.req;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 21:47
 */

import lombok.Data;

/**
 * 短链接分组排序参数
 */
@Data
public class ShortLinkGroupSortReqDTO {

    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序
     */
    private Integer sortOrder;
}

