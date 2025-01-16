package com.daydream.shortlink.project.controller;

/**
 * Author daydream
 * Description
 * Date 2025/1/15 20:23
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.daydream.shortlink.project.common.convention.result.Result;
import com.daydream.shortlink.project.common.convention.result.Results;
import com.daydream.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.daydream.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.daydream.shortlink.project.service.RecycleBinService;
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

    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }
    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return Results.success(recycleBinService.pageShortLink(requestParam));
    }
     /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecycleBin(requestParam);
        return Results.success();
    }
}

