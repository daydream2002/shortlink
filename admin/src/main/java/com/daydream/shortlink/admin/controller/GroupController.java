package com.daydream.shortlink.admin.controller;

import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.convention.result.Results;
import com.daydream.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.daydream.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 17:35
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    /**
     * 新建短链接分组
     */
    @PostMapping("/api/short-link/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO shortLinkGroupSaveReqDTO) {
        groupService.saveGroup(shortLinkGroupSaveReqDTO.getName());
        return Results.success();
    }
}
