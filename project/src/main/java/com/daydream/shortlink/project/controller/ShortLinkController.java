package com.daydream.shortlink.project.controller;

import com.daydream.shortlink.project.common.convention.result.Result;
import com.daydream.shortlink.project.common.convention.result.Results;
import com.daydream.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.daydream.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author daydream
 * Description
 * Date 2025/1/10 16:09
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO shortLinkCreateReqDTO) {
        return Results.success(shortLinkService.createShortLink(shortLinkCreateReqDTO));
    }
}
