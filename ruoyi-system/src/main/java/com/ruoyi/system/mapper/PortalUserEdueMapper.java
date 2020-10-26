package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.PortalUserEdue;

import java.util.List;

/**
 * 教育经历列Mapper接口
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
public interface PortalUserEdueMapper 
{
    /**
     * 查询教育经历列
     * 
     * @param edueId 教育经历列ID
     * @return 教育经历列
     */
    public PortalUserEdue selectPortalUserEdueById(Long edueId);

    /**
     * 查询教育经历列列表
     * 
     * @param portalUserEdue 教育经历列
     * @return 教育经历列集合
     */
    public List<PortalUserEdue> selectPortalUserEdueList(PortalUserEdue portalUserEdue);

    /**
     * 新增教育经历列
     * 
     * @param portalUserEdue 教育经历列
     * @return 结果
     */
    public int insertPortalUserEdue(PortalUserEdue portalUserEdue);

    /**
     * 修改教育经历列
     * 
     * @param portalUserEdue 教育经历列
     * @return 结果
     */
    public int updatePortalUserEdue(PortalUserEdue portalUserEdue);

    /**
     * 删除教育经历列
     * 
     * @param edueId 教育经历列ID
     * @return 结果
     */
    public int deletePortalUserEdueById(Long edueId);

    /**
     * 批量删除教育经历列
     * 
     * @param edueIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePortalUserEdueByIds(String[] edueIds);

    /**
     * 根据userId 批量删除教育经历
     * @param userIds
     * @return
     */
    public int deletePortalUserEdueByUserIds(String[] userIds);
}
