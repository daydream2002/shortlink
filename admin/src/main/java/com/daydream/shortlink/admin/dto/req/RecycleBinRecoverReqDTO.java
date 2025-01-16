package com.daydream.shortlink.admin.dto.req;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 11:23
 */

import lombok.Data;

/**
 * 回收站恢复功能
 */
@Data
public class RecycleBinRecoverReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}

