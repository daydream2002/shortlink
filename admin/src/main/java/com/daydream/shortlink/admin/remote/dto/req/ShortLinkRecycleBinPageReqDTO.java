package com.daydream.shortlink.admin.remote.dto.req;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 10:52
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 回收站短链接分页请求参数
 */
@Data
public class ShortLinkRecycleBinPageReqDTO extends Page {

    /**
     * 分组标识
     */
    private List<String> gidList;
}
