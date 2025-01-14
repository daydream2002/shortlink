package com.daydream.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daydream.shortlink.admin.common.biz.user.UserContext;
import com.daydream.shortlink.admin.common.convention.result.Result;
import com.daydream.shortlink.admin.common.database.BaseDO;
import com.daydream.shortlink.admin.dao.entity.GroupDO;
import com.daydream.shortlink.admin.dao.mapper.GroupMapper;
import com.daydream.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.daydream.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.daydream.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.daydream.shortlink.admin.remote.ShortLinkRemoteService;
import com.daydream.shortlink.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.daydream.shortlink.admin.service.GroupService;
import com.daydream.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 17:34
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    @Override
    public void saveGroup(String groupName) {
        saveGroup(UserContext.getUsername(), groupName);
    }

    @Override
    public void saveGroup(String username, String GroupName) {
        String gid;
        do {
            gid = RandomGenerator.generateRandom();
        } while (!hasGid(username, gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .sortOrder(0)
                .username(username)
                .name(GroupName)
                .build();
        save(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        List<GroupDO> list = list(Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0)
                .orderByDesc(GroupDO::getSortOrder, BaseDO::getUpdateTime));
        Result<List<ShortLinkGroupCountQueryRespDTO>> listResult = shortLinkRemoteService
                .listGroupShortLinkCount(list.stream().map(GroupDO::getGid).toList());
        List<ShortLinkGroupRespDTO> shortLinkGroupRespDTOList = BeanUtil.copyToList(list, ShortLinkGroupRespDTO.class);
        shortLinkGroupRespDTOList.forEach(item -> {
            listResult.getData()
                    .stream()
                    .filter(item1 -> item1.getGid().equals(item.getGid()))
                    .findFirst()
                    .ifPresent(item2 -> item.setShortLinkCount(item2.getShortLinkCount()));
        });
        return shortLinkGroupRespDTOList;
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO shortLinkGroupUpdateReqDTO) {
        GroupDO groupDO = new GroupDO();
        groupDO.setName(shortLinkGroupUpdateReqDTO.getName());
        update(groupDO, Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getGid, shortLinkGroupUpdateReqDTO.getGid())
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0));
    }

    @Override
    public void deleteGroup(String gid) {
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        update(groupDO, Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0));
    }

    @Override
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        requestParam.forEach(item -> {
            GroupDO groupDO = new GroupDO();
            groupDO.setSortOrder(item.getSortOrder());
            update(groupDO, Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getGid, item.getGid())
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getDelFlag, 0));
        });
    }

    private boolean hasGid(String username, String gid) {
        GroupDO groupDO = getOne(Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, Optional.ofNullable(username).orElse(UserContext.getUsername())));
        return groupDO == null;
    }
}
