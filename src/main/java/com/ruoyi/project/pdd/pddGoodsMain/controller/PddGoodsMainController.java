package com.ruoyi.project.pdd.pddGoodsMain.controller;

import cn.hutool.core.date.DateTime;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.service.IPddGoodsMainService;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.service.IPddGoodsMainStatusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 主记录信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddGoodsMain")
public class PddGoodsMainController extends BaseController
{
    private String prefix = "pdd/pddGoodsMain";
	
	@Autowired
	private IPddGoodsMainService pddGoodsMainService;

	@Autowired
	private IPddGoodsMainStatusService pddGoodsMainStatusService;
	
	@RequiresPermissions("pdd:pddGoodsMain:view")
	@GetMapping()
	public String pddGoodsMain()
	{
	    return prefix + "/pddGoodsMain";
	}
	
	/**
	 * 查询主记录列表
	 */
	@RequiresPermissions("pdd:pddGoodsMain:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsMain pddGoodsMain)
	{
		startPage();
        List<PddGoodsMain> list = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出主记录列表
	 */
	@RequiresPermissions("pdd:pddGoodsMain:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsMain pddGoodsMain)
    {
    	List<PddGoodsMain> list = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
        ExcelUtil<PddGoodsMain> util = new ExcelUtil<PddGoodsMain>(PddGoodsMain.class);
        return util.exportExcel(list, "pddGoodsMain");
    }
	
	/**
	 * 新增主记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存主记录
	 */
	@RequiresPermissions("pdd:pddGoodsMain:add")
	@Log(title = "主记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsMain pddGoodsMain)
	{
		PddGoodsMainStatus pddGoodsMainStatus = new PddGoodsMainStatus();
		pddGoodsMainStatus.setStartTime(new DateTime());
		int main_count = pddGoodsMainService.insertPddGoodsMain(pddGoodsMain);
		pddGoodsMainStatus.setGoodsId(pddGoodsMain.getGoodsId());
		pddGoodsMainStatus.setStatus(pddGoodsMain.getStatus());
		pddGoodsMainStatus.setMainId(pddGoodsMain.getMainId());
		pddGoodsMainStatus.setEndTime(new DateTime());
		pddGoodsMainStatusService.insertPddGoodsMainStatus(pddGoodsMainStatus);
		return toAjax(main_count);
	}

	/**
	 * 修改主记录
	 */
	@GetMapping("/edit/{mainId}")
	public String edit(@PathVariable("mainId") Long mainId, ModelMap mmap)
	{
		PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(mainId);
		mmap.put("pddGoodsMain", pddGoodsMain);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存主记录
	 */
	@RequiresPermissions("pdd:pddGoodsMain:edit")
	@Log(title = "主记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsMain pddGoodsMain)
	{		
		return toAjax(pddGoodsMainService.updatePddGoodsMain(pddGoodsMain));
	}
	
	/**
	 * 删除主记录
	 */
	@RequiresPermissions("pdd:pddGoodsMain:remove")
	@Log(title = "主记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsMainService.deletePddGoodsMainByIds(ids));
	}


	@GetMapping("/pddGoodsDataOriginId/{mainId}")
	public String pddGoodsDataOrigin(@PathVariable("mainId") Long mainId, ModelMap mmap)
	{
		mmap.put("mainId", mainId);
		return "pdd/pddGoodsDataOrigin" + "/pddGoodsDataOrigin";
	}

	@GetMapping("/pddGoodsDataAddId/{mainId}")
	public String pddGoodsDataAdd(@PathVariable("mainId") Long mainId, ModelMap mmap)
	{
		mmap.put("mainId", mainId);
		return "pdd/pddGoodsDataAdd" + "/pddGoodsDataAdd";
	}

	@GetMapping("/pddGoodsMainStatus/{mainId}")
	public String pddGoodsMainStatus(@PathVariable("mainId") Long mainId, ModelMap mmap)
	{
		mmap.put("mainId", mainId);
		return "pdd/pddGoodsMainStatus" + "/pddGoodsMainStatus";
	}
	
}
