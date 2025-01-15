package com.daydream.shortlink.admin.dto.req;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:19
 */

import lombok.Data;

/**
 * 回收站保存功能
 */
@Data
public class RecycleBinSaveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
