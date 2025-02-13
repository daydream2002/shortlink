package com.daydream.shortlink.admin.controller;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:31
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.convention.result.Results;
import com.daydream.shortlink.admin.dto.req.RecycleBinRecoverReqDTO;
import com.daydream.shortlink.admin.dto.req.RecycleBinRemoveReqDTO;
import com.daydream.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import com.daydream.shortlink.admin.remote.ShortLinkActualRemoteService;
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
@RestController(value = "recycleBinControllerByAdmin")
@RequiredArgsConstructor
public class RecycleBinController {
    private final com.daydream.shortlink.admin.service.recycleBinService recycleBinService;
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        shortLinkActualRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }
    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<Page<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }
    /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        shortLinkActualRemoteService.recoverRecycleBin(requestParam);
        return Results.success();
    }
    /**
     * 移除短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        shortLinkActualRemoteService.removeRecycleBin(requestParam);
        return Results.success();
    }
}

