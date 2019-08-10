package com.ruoyi.project.pdd.pddGoodsMainStatus.controller;

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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.service.IPddGoodsMainStatusService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 主记录状态信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddGoodsMainStatus")
public class PddGoodsMainStatusController extends BaseController
{
    private String prefix = "pdd/pddGoodsMainStatus";
	
	@Autowired
	private IPddGoodsMainStatusService pddGoodsMainStatusService;
	
	@RequiresPermissions("pdd:pddGoodsMainStatus:view")
	@GetMapping()
	public String pddGoodsMainStatus()
	{
	    return prefix + "/pddGoodsMainStatus";
	}
	
	/**
	 * 查询主记录状态列表
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsMainStatus pddGoodsMainStatus)
	{
		startPage();
        List<PddGoodsMainStatus> list = pddGoodsMainStatusService.selectPddGoodsMainStatusList(pddGoodsMainStatus);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出主记录状态列表
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsMainStatus pddGoodsMainStatus)
    {
    	List<PddGoodsMainStatus> list = pddGoodsMainStatusService.selectPddGoodsMainStatusList(pddGoodsMainStatus);
        ExcelUtil<PddGoodsMainStatus> util = new ExcelUtil<PddGoodsMainStatus>(PddGoodsMainStatus.class);
        return util.exportExcel(list, "pddGoodsMainStatus");
    }
	
	/**
	 * 新增主记录状态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:add")
	@Log(title = "主记录状态", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsMainStatus pddGoodsMainStatus)
	{		
		return toAjax(pddGoodsMainStatusService.insertPddGoodsMainStatus(pddGoodsMainStatus));
	}

	/**
	 * 修改主记录状态
	 */
	@GetMapping("/edit/{mainStatusId}")
	public String edit(@PathVariable("mainStatusId") Long mainStatusId, ModelMap mmap)
	{
		PddGoodsMainStatus pddGoodsMainStatus = pddGoodsMainStatusService.selectPddGoodsMainStatusById(mainStatusId);
		mmap.put("pddGoodsMainStatus", pddGoodsMainStatus);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:edit")
	@Log(title = "主记录状态", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsMainStatus pddGoodsMainStatus)
	{		
		return toAjax(pddGoodsMainStatusService.updatePddGoodsMainStatus(pddGoodsMainStatus));
	}
	
	/**
	 * 删除主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:remove")
	@Log(title = "主记录状态", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsMainStatusService.deletePddGoodsMainStatusByIds(ids));
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long mainStatusId, ModelMap mmap)
	{
		PddGoodsMainStatus pddGoodsMainStatus = pddGoodsMainStatusService.selectPddGoodsMainStatusById(mainStatusId);
		mmap.put("pddGoodsMainStatus", pddGoodsMainStatus);
		return prefix + "/detail";
	}
}
