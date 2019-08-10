package com.ruoyi.project.pdd.pddGoodsDataOrigin.controller;

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
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 原商品数据解析信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddGoodsDataOrigin")
public class PddGoodsDataOriginController extends BaseController
{
    private String prefix = "pdd/pddGoodsDataOrigin";
	
	@Autowired
	private IPddGoodsDataOriginService pddGoodsDataOriginService;
	
	@RequiresPermissions("pdd:pddGoodsDataOrigin:view")
	@GetMapping()
	public String pddGoodsDataOrigin()
	{
	    return prefix + "/pddGoodsDataOrigin";
	}
	
	/**
	 * 查询原商品数据解析列表
	 */
	@RequiresPermissions("pdd:pddGoodsDataOrigin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
		startPage();
        List<PddGoodsDataOrigin> list = pddGoodsDataOriginService.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出原商品数据解析列表
	 */
	@RequiresPermissions("pdd:pddGoodsDataOrigin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsDataOrigin pddGoodsDataOrigin)
    {
    	List<PddGoodsDataOrigin> list = pddGoodsDataOriginService.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
        ExcelUtil<PddGoodsDataOrigin> util = new ExcelUtil<PddGoodsDataOrigin>(PddGoodsDataOrigin.class);
        return util.exportExcel(list, "pddGoodsDataOrigin");
    }
	
	/**
	 * 新增原商品数据解析
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存原商品数据解析
	 */
	@RequiresPermissions("pdd:pddGoodsDataOrigin:add")
	@Log(title = "原商品数据解析", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsDataOrigin pddGoodsDataOrigin)
	{		
		return toAjax(pddGoodsDataOriginService.insertPddGoodsDataOrigin(pddGoodsDataOrigin));
	}

	/**
	 * 修改原商品数据解析
	 */
	@GetMapping("/edit/{goodsDataOriginId}")
	public String edit(@PathVariable("goodsDataOriginId") Long goodsDataOriginId, ModelMap mmap)
	{
		PddGoodsDataOrigin pddGoodsDataOrigin = pddGoodsDataOriginService.selectPddGoodsDataOriginById(goodsDataOriginId);
		mmap.put("pddGoodsDataOrigin", pddGoodsDataOrigin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存原商品数据解析
	 */
	@RequiresPermissions("pdd:pddGoodsDataOrigin:edit")
	@Log(title = "原商品数据解析", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsDataOrigin pddGoodsDataOrigin)
	{		
		return toAjax(pddGoodsDataOriginService.updatePddGoodsDataOrigin(pddGoodsDataOrigin));
	}
	
	/**
	 * 删除原商品数据解析
	 */
	@RequiresPermissions("pdd:pddGoodsDataOrigin:remove")
	@Log(title = "原商品数据解析", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsDataOriginService.deletePddGoodsDataOriginByIds(ids));
	}
	
}
