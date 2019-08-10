package com.ruoyi.project.pdd.pddGoodsDownload.controller;

import java.util.List;

import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
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
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 原商品数据下载信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddGoodsDownload")
public class PddGoodsDownloadController extends BaseController
{
    private String prefix = "pdd/pddGoodsDownload";
	
	@Autowired
	private IPddGoodsDownloadService pddGoodsDownloadService;
	
	@RequiresPermissions("pdd:pddGoodsDownload:view")
	@GetMapping()
	public String pddGoodsDownload()
	{
	    return prefix + "/pddGoodsDownload";
	}
	
	/**
	 * 查询原商品数据下载列表
	 */
	@RequiresPermissions("pdd:pddGoodsDownload:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsDownload pddGoodsDownload)
	{
		startPage();
        List<PddGoodsDownload> list = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出原商品数据下载列表
	 */
	@RequiresPermissions("pdd:pddGoodsDownload:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsDownload pddGoodsDownload)
    {
    	List<PddGoodsDownload> list = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
        ExcelUtil<PddGoodsDownload> util = new ExcelUtil<PddGoodsDownload>(PddGoodsDownload.class);
        return util.exportExcel(list, "pddGoodsDownload");
    }
	
	/**
	 * 新增原商品数据下载
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存原商品数据下载
	 */
	@RequiresPermissions("pdd:pddGoodsDownload:add")
	@Log(title = "原商品数据下载", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsDownload pddGoodsDownload)
	{		
		return toAjax(pddGoodsDownloadService.insertPddGoodsDownload(pddGoodsDownload));
	}

	/**
	 * 修改原商品数据下载
	 */
	@GetMapping("/edit/{downloadId}")
	public String edit(@PathVariable("downloadId") Long downloadId, ModelMap mmap)
	{
		PddGoodsDownload pddGoodsDownload = pddGoodsDownloadService.selectPddGoodsDownloadById(downloadId);
		mmap.put("pddGoodsDownload", pddGoodsDownload);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存原商品数据下载
	 */
	@RequiresPermissions("pdd:pddGoodsDownload:edit")
	@Log(title = "原商品数据下载", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsDownload pddGoodsDownload)
	{		
		return toAjax(pddGoodsDownloadService.updatePddGoodsDownload(pddGoodsDownload));
	}
	
	/**
	 * 删除原商品数据下载
	 */
	@RequiresPermissions("pdd:pddGoodsDownload:remove")
	@Log(title = "原商品数据下载", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsDownloadService.deletePddGoodsDownloadByIds(ids));
	}


	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long downloadId, ModelMap mmap)
	{
		PddGoodsDownload pddGoodsDownload = pddGoodsDownloadService.selectPddGoodsDownloadById(downloadId);
		mmap.put("pddGoodsDownload", pddGoodsDownload);
		return prefix + "/detail";
	}
	
}
