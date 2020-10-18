package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalUserMapper;
import com.ruoyi.system.domain.PortalUser;
import com.ruoyi.system.service.IPortalUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户信息Service业务层处理
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Service
public class PortalUserServiceImpl implements IPortalUserService 
{
    @Autowired
    private PortalUserMapper portalUserMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public PortalUser selectPortalUserById(Long userId)
    {
        return portalUserMapper.selectPortalUserById(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param portalUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<PortalUser> selectPortalUserList(PortalUser portalUser)
    {
        return portalUserMapper.selectPortalUserList(portalUser);
    }

    /**
     * 新增用户信息
     * 
     * @param portalUser 用户信息
     * @return 结果
     */
    @Override
    public int insertPortalUser(PortalUser portalUser)
    {
        portalUser.setCreateTime(DateUtils.getNowDate());
        return portalUserMapper.insertPortalUser(portalUser);
    }

    /**
     * 修改用户信息
     * 
     * @param portalUser 用户信息
     * @return 结果
     */
    @Override
    public int updatePortalUser(PortalUser portalUser)
    {
        portalUser.setUpdateTime(DateUtils.getNowDate());
        return portalUserMapper.updatePortalUser(portalUser);
    }

    /**
     * 删除用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePortalUserByIds(String ids)
    {
        return portalUserMapper.deletePortalUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deletePortalUserById(Long userId)
    {
        return portalUserMapper.deletePortalUserById(userId);
    }
}
