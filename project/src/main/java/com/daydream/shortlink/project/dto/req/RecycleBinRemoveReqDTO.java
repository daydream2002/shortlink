package com.daydream.shortlink.project.dto.req;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 11:38
 */

import lombok.Data;

/**
 * 回收站移除功能
 */
@Data
public class RecycleBinRemoveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}

