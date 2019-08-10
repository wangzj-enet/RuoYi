package com.ruoyi.project.pdd.pddSkuListOrigin.controller;

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
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.service.IPddSkuListOriginService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 原商品sku信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddSkuListOrigin")
public class PddSkuListOriginController extends BaseController
{
    private String prefix = "pdd/pddSkuListOrigin";
	
	@Autowired
	private IPddSkuListOriginService pddSkuListOriginService;
	
	@RequiresPermissions("pdd:pddSkuListOrigin:view")
	@GetMapping()
	public String pddSkuListOrigin()
	{
	    return prefix + "/pddSkuListOrigin";
	}
	
	/**
	 * 查询原商品sku列表
	 */
	@RequiresPermissions("pdd:pddSkuListOrigin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddSkuListOrigin pddSkuListOrigin)
	{
		startPage();
        List<PddSkuListOrigin> list = pddSkuListOriginService.selectPddSkuListOriginList(pddSkuListOrigin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出原商品sku列表
	 */
	@RequiresPermissions("pdd:pddSkuListOrigin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddSkuListOrigin pddSkuListOrigin)
    {
    	List<PddSkuListOrigin> list = pddSkuListOriginService.selectPddSkuListOriginList(pddSkuListOrigin);
        ExcelUtil<PddSkuListOrigin> util = new ExcelUtil<PddSkuListOrigin>(PddSkuListOrigin.class);
        return util.exportExcel(list, "pddSkuListOrigin");
    }
	
	/**
	 * 新增原商品sku
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存原商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListOrigin:add")
	@Log(title = "原商品sku", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddSkuListOrigin pddSkuListOrigin)
	{		
		return toAjax(pddSkuListOriginService.insertPddSkuListOrigin(pddSkuListOrigin));
	}

	/**
	 * 修改原商品sku
	 */
	@GetMapping("/edit/{skuListOriginId}")
	public String edit(@PathVariable("skuListOriginId") Long skuListOriginId, ModelMap mmap)
	{
		PddSkuListOrigin pddSkuListOrigin = pddSkuListOriginService.selectPddSkuListOriginById(skuListOriginId);
		mmap.put("pddSkuListOrigin", pddSkuListOrigin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存原商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListOrigin:edit")
	@Log(title = "原商品sku", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddSkuListOrigin pddSkuListOrigin)
	{		
		return toAjax(pddSkuListOriginService.updatePddSkuListOrigin(pddSkuListOrigin));
	}
	
	/**
	 * 删除原商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListOrigin:remove")
	@Log(title = "原商品sku", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddSkuListOriginService.deletePddSkuListOriginByIds(ids));
	}
	
}
