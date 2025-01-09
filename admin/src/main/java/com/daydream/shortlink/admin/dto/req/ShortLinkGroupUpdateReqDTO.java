package com.daydream.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 17:36
 */
@Data
public class ShortLinkGroupUpdateReqDTO {
    /**
     * 分组id
     */
    private String gid;
    /**
     * 分组名称
     */
    private String name;
}
