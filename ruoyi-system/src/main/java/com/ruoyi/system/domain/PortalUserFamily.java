package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 家庭成员列对象 portal_user_family
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
public class PortalUserFamily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭成员 */
    private Long familyId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 与本人关系 */
    @Excel(name = "与本人关系")
    private String fRelationship;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String fPhone;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String fWorkUnit;

    public void setFamilyId(Long familyId) 
    {
        this.familyId = familyId;
    }

    public Long getFamilyId() 
    {
        return familyId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setfRelationship(String fRelationship) 
    {
        this.fRelationship = fRelationship;
    }

    public String getfRelationship() 
    {
        return fRelationship;
    }
    public void setfName(String fName) 
    {
        this.fName = fName;
    }

    public String getfName() 
    {
        return fName;
    }
    public void setfPhone(String fPhone) 
    {
        this.fPhone = fPhone;
    }

    public String getfPhone() 
    {
        return fPhone;
    }
    public void setfWorkUnit(String fWorkUnit) 
    {
        this.fWorkUnit = fWorkUnit;
    }

    public String getfWorkUnit() 
    {
        return fWorkUnit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("familyId", getFamilyId())
            .append("userId", getUserId())
            .append("fRelationship", getfRelationship())
            .append("fName", getfName())
            .append("fPhone", getfPhone())
            .append("fWorkUnit", getfWorkUnit())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
