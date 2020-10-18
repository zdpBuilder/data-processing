package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalUserFamilyMapper;
import com.ruoyi.system.domain.PortalUserFamily;
import com.ruoyi.system.service.IPortalUserFamilyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 家庭成员列Service业务层处理
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Service
public class PortalUserFamilyServiceImpl implements IPortalUserFamilyService 
{
    @Autowired
    private PortalUserFamilyMapper portalUserFamilyMapper;

    /**
     * 查询家庭成员列
     * 
     * @param familyId 家庭成员列ID
     * @return 家庭成员列
     */
    @Override
    public PortalUserFamily selectPortalUserFamilyById(Long familyId)
    {
        return portalUserFamilyMapper.selectPortalUserFamilyById(familyId);
    }

    /**
     * 查询家庭成员列列表
     * 
     * @param portalUserFamily 家庭成员列
     * @return 家庭成员列
     */
    @Override
    public List<PortalUserFamily> selectPortalUserFamilyList(PortalUserFamily portalUserFamily)
    {
        return portalUserFamilyMapper.selectPortalUserFamilyList(portalUserFamily);
    }

    /**
     * 新增家庭成员列
     * 
     * @param portalUserFamily 家庭成员列
     * @return 结果
     */
    @Override
    public int insertPortalUserFamily(PortalUserFamily portalUserFamily)
    {
        portalUserFamily.setCreateTime(DateUtils.getNowDate());
        return portalUserFamilyMapper.insertPortalUserFamily(portalUserFamily);
    }

    /**
     * 修改家庭成员列
     * 
     * @param portalUserFamily 家庭成员列
     * @return 结果
     */
    @Override
    public int updatePortalUserFamily(PortalUserFamily portalUserFamily)
    {
        portalUserFamily.setUpdateTime(DateUtils.getNowDate());
        return portalUserFamilyMapper.updatePortalUserFamily(portalUserFamily);
    }

    /**
     * 删除家庭成员列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePortalUserFamilyByIds(String ids)
    {
        return portalUserFamilyMapper.deletePortalUserFamilyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家庭成员列信息
     * 
     * @param familyId 家庭成员列ID
     * @return 结果
     */
    @Override
    public int deletePortalUserFamilyById(Long familyId)
    {
        return portalUserFamilyMapper.deletePortalUserFamilyById(familyId);
    }
}
