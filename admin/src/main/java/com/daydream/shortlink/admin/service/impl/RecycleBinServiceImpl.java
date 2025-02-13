package com.daydream.shortlink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daydream.shortlink.admin.common.biz.user.UserContext;
import com.daydream.shortlink.admin.common.convention.exception.ServiceException;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.dao.entity.GroupDO;
import com.daydream.shortlink.admin.dao.mapper.GroupMapper;
import com.daydream.shortlink.admin.remote.ShortLinkActualRemoteService;
import com.daydream.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.daydream.shortlink.admin.service.recycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 10:50
 */
@Service(value = "recycleBinServiceImplByAdmin")
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements recycleBinService {
    private final GroupMapper groupMapper;
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 后续重构为 SpringCloud Feign 调用
     */

    @Override
    public Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        List<GroupDO> groupDOList = groupMapper.selectList(Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0));
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkActualRemoteService.pageRecycleBinShortLink(requestParam.getGidList(), requestParam.getCurrent(), requestParam.getSize());

    }
}
