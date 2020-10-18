package com.ruoyi.system.domain;

import java.util.Date;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教育经历列对象 portal_user_edue
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
public class PortalUserEdue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭成员ID */
    private Long edueId;

    /** 用户id */
    private Long userId;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eStartTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eEndTime;

    /** 学校 */
    @Excel(name = "学校")
    private String eSchool;

    /** 担任职务 */
    @Excel(name = "担任职务")
    private String ePost;

    public void setEdueId(Long edueId) 
    {
        this.edueId = edueId;
    }

    public Long getEdueId() 
    {
        return edueId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void seteStartTime(Date eStartTime) 
    {
        this.eStartTime = eStartTime;
    }

    public Date geteStartTime() 
    {
        return eStartTime;
    }
    public void seteEndTime(Date eEndTime) 
    {
        this.eEndTime = eEndTime;
    }

    public Date geteEndTime() 
    {
        return eEndTime;
    }
    public void seteSchool(String eSchool) 
    {
        this.eSchool = eSchool;
    }

    public String geteSchool() 
    {
        return eSchool;
    }
    public void setePost(String ePost) 
    {
        this.ePost = ePost;
    }

    public String getePost() 
    {
        return ePost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("edueId", getEdueId())
            .append("userId", getUserId())
            .append("eStartTime", geteStartTime())
            .append("eEndTime", geteEndTime())
            .append("eSchool", geteSchool())
            .append("ePost", getePost())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
