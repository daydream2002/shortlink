package com.daydream.shortlink.admin.controller;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:31
 */

import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.convention.result.Results;
import com.daydream.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import com.daydream.shortlink.admin.remote.ShortLinkRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {
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
}

