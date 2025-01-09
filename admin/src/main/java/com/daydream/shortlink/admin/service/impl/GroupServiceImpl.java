package com.daydream.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daydream.shortlink.admin.dao.entity.GroupDO;
import com.daydream.shortlink.admin.dao.mapper.GroupMapper;
import com.daydream.shortlink.admin.service.GroupService;
import com.daydream.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 17:34
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(String GroupName) {
        String gid;
        do {
            gid = RandomGenerator.generateRandom();
        } while (!hasGid(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(GroupName)
                .build();
        save(groupDO);
    }

    private boolean hasGid(String gid) {
        GroupDO groupDO = getOne(Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, null));
        return groupDO == null;
    }
}
