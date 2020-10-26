package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.PortalUser;
import com.ruoyi.system.domain.PortalUserEdue;
import com.ruoyi.system.domain.PortalUserFamily;
import com.ruoyi.system.mapper.PortalUserEdueMapper;
import com.ruoyi.system.mapper.PortalUserFamilyMapper;
import com.ruoyi.system.mapper.PortalUserMapper;
import com.ruoyi.system.service.IPortalUserEdueService;
import com.ruoyi.system.service.IPortalUserFamilyService;
import com.ruoyi.system.service.IPortalUserService;
import com.ruoyi.system.vo.PortalUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private IPortalUserFamilyService iPortalUserFamilyService;
    @Autowired
    private IPortalUserEdueService iPortalUserEdueService;
    @Autowired
    private PortalUserEdueMapper portalUserEdueMapper;
    @Autowired
    private PortalUserFamilyMapper protalUserFamilyMapper;

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
    @Transactional
    @Override
    public int insertPortalUser(PortalUserVo portalUser)
    {
        int result = 0;
        portalUser.setCreateTime(DateUtils.getNowDate());
        //插入用户信息
        result += portalUserMapper.insertPortalUser(portalUser);

        //插入家庭成员
        if(portalUser.getPortalUserFamily()!=null && portalUser.getPortalUserFamily().size()>0){
            for (PortalUserFamily portalUserFamily: portalUser.getPortalUserFamily()
                 ) {
                portalUserFamily.setUserId(portalUser.getUserId());
                result +=  iPortalUserFamilyService.insertPortalUserFamily(portalUserFamily);
            }
        }
        //插入经历
        if(portalUser.getPortalUserEdue()!=null && portalUser.getPortalUserEdue().size()>0){
            for (PortalUserEdue portalUserEdue: portalUser.getPortalUserEdue()
            ) {
                portalUserEdue.setUserId(portalUser.getUserId());
                result += iPortalUserEdueService.insertPortalUserEdue(portalUserEdue);
            }
        }

        return result;
    }

    /**
     * 修改用户信息
     * 
     * @param portalUser 用户信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePortalUser(PortalUserVo portalUser)
    {
        int result = 0;
        //更新主表
        portalUser.setUpdateTime(DateUtils.getNowDate());
        result+=portalUserMapper.updatePortalUser(portalUser);
        //删除子表
        portalUserEdueMapper.deletePortalUserEdueByUserIds(Convert.toStrArray(String.valueOf(portalUser.getUserId())));
        protalUserFamilyMapper.deletePortalUserFamilyByUserIds(Convert.toStrArray(String.valueOf(portalUser.getUserId())));
        //插入子表
        //插入家庭成员
        if(portalUser.getPortalUserFamily()!=null && portalUser.getPortalUserFamily().size()>0){
            for (PortalUserFamily portalUserFamily: portalUser.getPortalUserFamily()
            ) {
                portalUserFamily.setUserId(portalUser.getUserId());
                result +=  iPortalUserFamilyService.insertPortalUserFamily(portalUserFamily);
            }
        }
        //插入经历
        if(portalUser.getPortalUserEdue()!=null && portalUser.getPortalUserEdue().size()>0){
            for (PortalUserEdue portalUserEdue: portalUser.getPortalUserEdue()
            ) {
                portalUserEdue.setUserId(portalUser.getUserId());
                result += iPortalUserEdueService.insertPortalUserEdue(portalUserEdue);
            }
        }

        return result;
    }

    /**
     * 删除用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePortalUserByIds(String ids)
    {

        String[] idsArry = Convert.toStrArray(ids);
        //删除子表
        portalUserEdueMapper.deletePortalUserEdueByUserIds(Convert.toStrArray(ids));
        protalUserFamilyMapper.deletePortalUserFamilyByUserIds(Convert.toStrArray(ids));

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
