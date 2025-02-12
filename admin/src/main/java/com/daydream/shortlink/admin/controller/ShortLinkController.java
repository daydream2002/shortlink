package com.daydream.shortlink.admin.controller;

/**
 * Author daydream
 * Description
 * Date 2025/1/13 16:43
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.convention.result.Results;
import com.daydream.shortlink.admin.remote.ShortLinkActualRemoteService;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkBatchCreateReqDTO;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkBaseInfoRespDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkBatchCreateRespDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.daydream.shortlink.admin.toolkit.EasyExcelWebUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 短链接后管控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {


    private final ShortLinkActualRemoteService shortLinkActualRemoteService;


    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkActualRemoteService.createShortLink(requestParam);
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<Page<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkActualRemoteService.pageShortLink(requestParam.getGid(), requestParam.getOrderTag(), requestParam.getCurrent(), requestParam.getSize());
    }

    /**
     * 修改短链接
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkActualRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 批量创建短链接
     */
    @SneakyThrows
    @PostMapping("/api/short-link/admin/v1/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkActualRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
        }
    }
}