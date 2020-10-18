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
import com.ruoyi.system.domain.PortalUserEdue;
import com.ruoyi.system.service.IPortalUserEdueService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教育经历列Controller
 * 
 * @author zdpBuilder
 * @date 2020-10-15
 */
@Controller
@RequestMapping("/system/portalUserEdue")
public class PortalUserEdueController extends BaseController
{
    private String prefix = "system/portalUserEdue";

    @Autowired
    private IPortalUserEdueService portalUserEdueService;

    @RequiresPermissions("system:portalUserEdue:view")
    @GetMapping()
    public String portalUserEdue()
    {
        return prefix + "/portalUserEdue";
    }

    /**
     * 查询教育经历列列表
     */
    @RequiresPermissions("system:portalUserEdue:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalUserEdue portalUserEdue)
    {
        startPage();
        List<PortalUserEdue> list = portalUserEdueService.selectPortalUserEdueList(portalUserEdue);
        return getDataTable(list);
    }

    /**
     * 导出教育经历列列表
     */
    @RequiresPermissions("system:portalUserEdue:export")
    @Log(title = "教育经历列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalUserEdue portalUserEdue)
    {
        List<PortalUserEdue> list = portalUserEdueService.selectPortalUserEdueList(portalUserEdue);
        ExcelUtil<PortalUserEdue> util = new ExcelUtil<PortalUserEdue>(PortalUserEdue.class);
        return util.exportExcel(list, "portalUserEdue");
    }

    /**
     * 新增教育经历列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教育经历列
     */
    @RequiresPermissions("system:portalUserEdue:add")
    @Log(title = "教育经历列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalUserEdue portalUserEdue)
    {
        return toAjax(portalUserEdueService.insertPortalUserEdue(portalUserEdue));
    }

    /**
     * 修改教育经历列
     */
    @GetMapping("/edit/{edueId}")
    public String edit(@PathVariable("edueId") Long edueId, ModelMap mmap)
    {
        PortalUserEdue portalUserEdue = portalUserEdueService.selectPortalUserEdueById(edueId);
        mmap.put("portalUserEdue", portalUserEdue);
        return prefix + "/edit";
    }

    /**
     * 修改保存教育经历列
     */
    @RequiresPermissions("system:portalUserEdue:edit")
    @Log(title = "教育经历列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalUserEdue portalUserEdue)
    {
        return toAjax(portalUserEdueService.updatePortalUserEdue(portalUserEdue));
    }

    /**
     * 删除教育经历列
     */
    @RequiresPermissions("system:portalUserEdue:remove")
    @Log(title = "教育经历列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalUserEdueService.deletePortalUserEdueByIds(ids));
    }
}
