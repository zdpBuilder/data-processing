package com.ruoyi.system.service;

import com.ruoyi.system.domain.PortalUser;
import com.ruoyi.system.vo.PortalUserVo;

import java.util.List;

/**
 * 用户信息Service接口
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
public interface IPortalUserService 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public PortalUser selectPortalUserById(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param portalUser 用户信息
     * @return 用户信息集合
     */
    public List<PortalUser> selectPortalUserList(PortalUser portalUser);

    /**
     * 新增用户信息
     * 
     * @param portalUser 用户信息
     * @return 结果
     */
    public int insertPortalUser(PortalUserVo portalUser);

    /**
     * 修改用户信息
     * 
     * @param portalUser 用户信息
     * @return 结果
     */
    public int updatePortalUser(PortalUserVo portalUser);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePortalUserByIds(String ids);

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deletePortalUserById(Long userId);
}
