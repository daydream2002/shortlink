package com.daydream.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

/**
 * Author daydream
 * Description
 * Date 2025/1/13 11:39
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}
