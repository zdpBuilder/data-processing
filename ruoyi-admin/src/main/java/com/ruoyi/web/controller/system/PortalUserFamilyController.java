package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PortalUserFamily;
import com.ruoyi.system.service.IPortalUserFamilyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 家庭成员列Controller
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Controller
@RequestMapping("/system/portalUserFamily")
public class PortalUserFamilyController extends BaseController
{
    private String prefix = "system/portalUserFamily";

    @Autowired
    private IPortalUserFamilyService portalUserFamilyService;

    @RequiresPermissions("system:portalUserFamily:view")
    @GetMapping()
    public String portalUserFamily()
    {
        return prefix + "/portalUserFamily";
    }

    /**
     * 查询家庭成员列列表
     */
    @RequiresPermissions("system:portalUserFamily:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalUserFamily portalUserFamily)
    {
        startPage();
        List<PortalUserFamily> list = portalUserFamilyService.selectPortalUserFamilyList(portalUserFamily);
        return getDataTable(list);
    }

    /**
     * 导出家庭成员列列表
     */
    @RequiresPermissions("system:portalUserFamily:export")
    @Log(title = "家庭成员列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalUserFamily portalUserFamily)
    {
        List<PortalUserFamily> list = portalUserFamilyService.selectPortalUserFamilyList(portalUserFamily);
        ExcelUtil<PortalUserFamily> util = new ExcelUtil<PortalUserFamily>(PortalUserFamily.class);
        return util.exportExcel(list, "portalUserFamily");
    }

    /**
     * 新增家庭成员列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭成员列
     */
    @RequiresPermissions("system:portalUserFamily:add")
    @Log(title = "家庭成员列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalUserFamily portalUserFamily)
    {
        return toAjax(portalUserFamilyService.insertPortalUserFamily(portalUserFamily));
    }

    /**
     * 修改家庭成员列
     */
    @GetMapping("/edit/{familyId}")
    public String edit(@PathVariable("familyId") Long familyId, ModelMap mmap)
    {
        PortalUserFamily portalUserFamily = portalUserFamilyService.selectPortalUserFamilyById(familyId);
        mmap.put("portalUserFamily", portalUserFamily);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭成员列
     */
    @RequiresPermissions("system:portalUserFamily:edit")
    @Log(title = "家庭成员列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalUserFamily portalUserFamily)
    {
        return toAjax(portalUserFamilyService.updatePortalUserFamily(portalUserFamily));
    }

    /**
     * 删除家庭成员列
     */
    @RequiresPermissions("system:portalUserFamily:remove")
    @Log(title = "家庭成员列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalUserFamilyService.deletePortalUserFamilyByIds(ids));
    }
}
