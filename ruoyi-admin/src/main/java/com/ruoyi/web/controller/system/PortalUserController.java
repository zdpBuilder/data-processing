package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PortalUser;
import com.ruoyi.system.domain.PortalUserEdue;
import com.ruoyi.system.domain.PortalUserFamily;
import com.ruoyi.system.service.IPortalUserEdueService;
import com.ruoyi.system.service.IPortalUserFamilyService;
import com.ruoyi.system.service.IPortalUserService;
import com.ruoyi.system.vo.PortalUserVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息Controller
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Controller
@RequestMapping("/system/portalUser")
public class PortalUserController extends BaseController
{
    private String prefix = "system/portalUser";

    @Autowired
    private IPortalUserService portalUserService;

    @Autowired
    private IPortalUserFamilyService iPortalUserFamilyService;
    @Autowired
    private IPortalUserEdueService iPortalUserEdueService;

    @RequiresPermissions("system:portalUser:view")
    @GetMapping()
    public String portalUser()
    {
        return prefix + "/portalUser";
    }

    /**
     * 查询用户信息列表
     */
    @RequiresPermissions("system:portalUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalUser portalUser)
    {
        startPage();
        List<PortalUser> list = portalUserService.selectPortalUserList(portalUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("system:portalUser:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalUser portalUser)
    {
        List<PortalUser> list = portalUserService.selectPortalUserList(portalUser);
        ExcelUtil<PortalUser> util = new ExcelUtil<PortalUser>(PortalUser.class);
        return util.exportExcel(list, "portalUser");
    }

    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("system:portalUser:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalUserVo portalUser)
    {

        return toAjax(portalUserService.insertPortalUser(portalUser));
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        PortalUser portalUser = portalUserService.selectPortalUserById(userId);
        PortalUserEdue  portalUserEdue=new PortalUserEdue();
        portalUserEdue.setUserId(userId);
        List<PortalUserEdue> portalUserEdues = iPortalUserEdueService.selectPortalUserEdueList(portalUserEdue);
        PortalUserFamily portalUserFamily=new PortalUserFamily();
        portalUserFamily.setUserId(userId);
        List<PortalUserFamily> portalUserFamilies = iPortalUserFamilyService.selectPortalUserFamilyList(portalUserFamily);
        mmap.put("portalUser", portalUser);
        mmap.put("portalUserEdues",portalUserEdues);
        mmap.put("portalUserFamilies",portalUserFamilies);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("system:portalUser:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalUserVo portalUser)
    {
        return toAjax(portalUserService.updatePortalUser(portalUser));
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("system:portalUser:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalUserService.deletePortalUserByIds(ids));
    }
}
