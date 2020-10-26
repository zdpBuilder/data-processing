package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.PortalUserFamily;

import java.util.List;

/**
 * 家庭成员列Mapper接口
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
public interface PortalUserFamilyMapper 
{
    /**
     * 查询家庭成员列
     * 
     * @param familyId 家庭成员列ID
     * @return 家庭成员列
     */
    public PortalUserFamily selectPortalUserFamilyById(Long familyId);

    /**
     * 查询家庭成员列列表
     * 
     * @param portalUserFamily 家庭成员列
     * @return 家庭成员列集合
     */
    public List<PortalUserFamily> selectPortalUserFamilyList(PortalUserFamily portalUserFamily);

    /**
     * 新增家庭成员列
     * 
     * @param portalUserFamily 家庭成员列
     * @return 结果
     */
    public int insertPortalUserFamily(PortalUserFamily portalUserFamily);

    /**
     * 修改家庭成员列
     * 
     * @param portalUserFamily 家庭成员列
     * @return 结果
     */
    public int updatePortalUserFamily(PortalUserFamily portalUserFamily);

    /**
     * 删除家庭成员列
     * 
     * @param familyId 家庭成员列ID
     * @return 结果
     */
    public int deletePortalUserFamilyById(Long familyId);

    /**
     * 批量删除家庭成员列
     * 
     * @param familyIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePortalUserFamilyByIds(String[] familyIds);

    /**
     * 根据用户ID删除家庭成员列表
     * @param userIds 要删除的数据ID
     * @return
     */
    public int deletePortalUserFamilyByUserIds(String[] userIds);
}
