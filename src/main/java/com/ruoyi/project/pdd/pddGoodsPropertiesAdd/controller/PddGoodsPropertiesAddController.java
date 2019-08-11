package com.ruoyi.project.pdd.pddGoodsPropertiesAdd.controller;

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
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service.IPddGoodsPropertiesAddService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 商品属性信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-11
 */
@Controller
@RequestMapping("/pdd/pddGoodsPropertiesAdd")
public class PddGoodsPropertiesAddController extends BaseController
{
    private String prefix = "pdd/pddGoodsPropertiesAdd";
	
	@Autowired
	private IPddGoodsPropertiesAddService pddGoodsPropertiesAddService;
	
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:view")
	@GetMapping()
	public String pddGoodsPropertiesAdd()
	{
	    return prefix + "/pddGoodsPropertiesAdd";
	}
	
	/**
	 * 查询商品属性列表
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{
		startPage();
        List<PddGoodsPropertiesAdd> list = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品属性列表
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
    {
    	List<PddGoodsPropertiesAdd> list = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);
        ExcelUtil<PddGoodsPropertiesAdd> util = new ExcelUtil<PddGoodsPropertiesAdd>(PddGoodsPropertiesAdd.class);
        return util.exportExcel(list, "pddGoodsPropertiesAdd");
    }
	
	/**
	 * 新增商品属性
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:add")
	@Log(title = "商品属性", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{		
		return toAjax(pddGoodsPropertiesAddService.insertPddGoodsPropertiesAdd(pddGoodsPropertiesAdd));
	}

	/**
	 * 修改商品属性
	 */
	@GetMapping("/edit/{goodsPropertiesAddId}")
	public String edit(@PathVariable("goodsPropertiesAddId") Long goodsPropertiesAddId, ModelMap mmap)
	{
		PddGoodsPropertiesAdd pddGoodsPropertiesAdd = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddById(goodsPropertiesAddId);
		mmap.put("pddGoodsPropertiesAdd", pddGoodsPropertiesAdd);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:edit")
	@Log(title = "商品属性", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{		
		return toAjax(pddGoodsPropertiesAddService.updatePddGoodsPropertiesAdd(pddGoodsPropertiesAdd));
	}
	
	/**
	 * 删除商品属性
	 */
	@RequiresPermissions("pdd:pddGoodsPropertiesAdd:remove")
	@Log(title = "商品属性", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsPropertiesAddService.deletePddGoodsPropertiesAddByIds(ids));
	}
	
}
