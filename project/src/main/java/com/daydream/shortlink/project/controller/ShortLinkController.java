package com.daydream.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.daydream.shortlink.project.common.convention.result.Result;
import com.daydream.shortlink.project.common.convention.result.Results;
import com.daydream.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.daydream.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.daydream.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2025/1/10 16:09
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO shortLinkCreateReqDTO) {
        return Results.success(shortLinkService.createShortLink(shortLinkCreateReqDTO));
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    /**
     * 查询短链接分组内数量
     */
    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam) {
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }

    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

}
