package com.daydream.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.daydream.shortlink.admin.dao.entity.GroupDO;
import com.daydream.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2025/1/9 17:33
 */
public interface GroupService extends IService<GroupDO> {
    void saveGroup(String GroupName);

    List<ShortLinkGroupRespDTO> listGroup();
}
