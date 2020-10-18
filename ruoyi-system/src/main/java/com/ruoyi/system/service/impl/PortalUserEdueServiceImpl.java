package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalUserEdueMapper;
import com.ruoyi.system.domain.PortalUserEdue;
import com.ruoyi.system.service.IPortalUserEdueService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教育经历列Service业务层处理
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Service
public class PortalUserEdueServiceImpl implements IPortalUserEdueService 
{
    @Autowired
    private PortalUserEdueMapper portalUserEdueMapper;

    /**
     * 查询教育经历列
     * 
     * @param edueId 教育经历列ID
     * @return 教育经历列
     */
    @Override
    public PortalUserEdue selectPortalUserEdueById(Long edueId)
    {
        return portalUserEdueMapper.selectPortalUserEdueById(edueId);
    }

    /**
     * 查询教育经历列列表
     * 
     * @param portalUserEdue 教育经历列
     * @return 教育经历列
     */
    @Override
    public List<PortalUserEdue> selectPortalUserEdueList(PortalUserEdue portalUserEdue)
    {
        return portalUserEdueMapper.selectPortalUserEdueList(portalUserEdue);
    }

    /**
     * 新增教育经历列
     * 
     * @param portalUserEdue 教育经历列
     * @return 结果
     */
    @Override
    public int insertPortalUserEdue(PortalUserEdue portalUserEdue)
    {
        portalUserEdue.setCreateTime(DateUtils.getNowDate());
        return portalUserEdueMapper.insertPortalUserEdue(portalUserEdue);
    }

    /**
     * 修改教育经历列
     * 
     * @param portalUserEdue 教育经历列
     * @return 结果
     */
    @Override
    public int updatePortalUserEdue(PortalUserEdue portalUserEdue)
    {
        portalUserEdue.setUpdateTime(DateUtils.getNowDate());
        return portalUserEdueMapper.updatePortalUserEdue(portalUserEdue);
    }

    /**
     * 删除教育经历列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePortalUserEdueByIds(String ids)
    {
        return portalUserEdueMapper.deletePortalUserEdueByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教育经历列信息
     * 
     * @param edueId 教育经历列ID
     * @return 结果
     */
    @Override
    public int deletePortalUserEdueById(Long edueId)
    {
        return portalUserEdueMapper.deletePortalUserEdueById(edueId);
    }
}
