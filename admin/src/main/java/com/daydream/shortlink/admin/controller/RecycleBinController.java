package com.daydream.shortlink.admin.controller;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:31
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.convention.result.Results;
import com.daydream.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import com.daydream.shortlink.admin.remote.ShortLinkRemoteService;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {
    private final com.daydream.shortlink.admin.service.recycleBinService recycleBinService;
    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        shortLinkRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }
    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }
}

