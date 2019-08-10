package com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.controller;

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
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service.IPddGoodsPropertiesOriginService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 原商品属性信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddGoodsPropertiesOrigin")
public class PddGoodsPropertiesOriginController extends BaseController
{
    private String prefix = "pdd/pddGoodsPropertiesOrigin";
	
	@Autowired
	private IPddGoodsPropertiesOriginService pddGoodsPropertiesOriginService;
	
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:view")
	@GetMapping()
	public String pddGoodsPropertiesOrigin()
	{
	    return prefix + "/pddGoodsPropertiesOrigin";
	}
	
	/**
	 * 查询原商品属性列表
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{
		startPage();
        List<PddGoodsPropertiesOrigin> list = pddGoodsPropertiesOriginService.selectPddGoodsPropertiesOriginList(pddGoodsPropertiesOrigin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出原商品属性列表
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
    {
    	List<PddGoodsPropertiesOrigin> list = pddGoodsPropertiesOriginService.selectPddGoodsPropertiesOriginList(pddGoodsPropertiesOrigin);
        ExcelUtil<PddGoodsPropertiesOrigin> util = new ExcelUtil<PddGoodsPropertiesOrigin>(PddGoodsPropertiesOrigin.class);
        return util.exportExcel(list, "pddGoodsPropertiesOrigin");
    }
	
	/**
	 * 新增原商品属性
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存原商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:add")
	@Log(title = "原商品属性", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{		
		return toAjax(pddGoodsPropertiesOriginService.insertPddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin));
	}

	/**
	 * 修改原商品属性
	 */
	@GetMapping("/edit/{goodsPropertiesOriginId}")
	public String edit(@PathVariable("goodsPropertiesOriginId") Long goodsPropertiesOriginId, ModelMap mmap)
	{
		PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = pddGoodsPropertiesOriginService.selectPddGoodsPropertiesOriginById(goodsPropertiesOriginId);
		mmap.put("pddGoodsPropertiesOrigin", pddGoodsPropertiesOrigin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存原商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:edit")
	@Log(title = "原商品属性", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{		
		return toAjax(pddGoodsPropertiesOriginService.updatePddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin));
	}
	
	/**
	 * 删除原商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesOrigin:remove")
	@Log(title = "原商品属性", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsPropertiesOriginService.deletePddGoodsPropertiesOriginByIds(ids));
	}
	
}
