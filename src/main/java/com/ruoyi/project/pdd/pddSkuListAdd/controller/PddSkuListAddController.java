package com.ruoyi.project.pdd.pddSkuListAdd.controller;

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
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.service.IPddSkuListAddService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 复制商品sku信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/pdd/pddSkuListAdd")
public class PddSkuListAddController extends BaseController
{
    private String prefix = "pdd/pddSkuListAdd";
	
	@Autowired
	private IPddSkuListAddService pddSkuListAddService;
	
	@RequiresPermissions("pdd:pddSkuListAdd:view")
	@GetMapping()
	public String pddSkuListAdd()
	{
	    return prefix + "/pddSkuListAdd";
	}
	
	/**
	 * 查询复制商品sku列表
	 */
	@RequiresPermissions("pdd:pddSkuListAdd:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddSkuListAdd pddSkuListAdd)
	{
		startPage();
        List<PddSkuListAdd> list = pddSkuListAddService.selectPddSkuListAddList(pddSkuListAdd);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出复制商品sku列表
	 */
	@RequiresPermissions("pdd:pddSkuListAdd:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddSkuListAdd pddSkuListAdd)
    {
    	List<PddSkuListAdd> list = pddSkuListAddService.selectPddSkuListAddList(pddSkuListAdd);
        ExcelUtil<PddSkuListAdd> util = new ExcelUtil<PddSkuListAdd>(PddSkuListAdd.class);
        return util.exportExcel(list, "pddSkuListAdd");
    }
	
	/**
	 * 新增复制商品sku
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存复制商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListAdd:add")
	@Log(title = "复制商品sku", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddSkuListAdd pddSkuListAdd)
	{		
		return toAjax(pddSkuListAddService.insertPddSkuListAdd(pddSkuListAdd));
	}

	/**
	 * 修改复制商品sku
	 */
	@GetMapping("/edit/{skuListAddId}")
	public String edit(@PathVariable("skuListAddId") Long skuListAddId, ModelMap mmap)
	{
		PddSkuListAdd pddSkuListAdd = pddSkuListAddService.selectPddSkuListAddById(skuListAddId);
		mmap.put("pddSkuListAdd", pddSkuListAdd);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存复制商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListAdd:edit")
	@Log(title = "复制商品sku", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddSkuListAdd pddSkuListAdd)
	{		
		return toAjax(pddSkuListAddService.updatePddSkuListAdd(pddSkuListAdd));
	}
	
	/**
	 * 删除复制商品sku
	 */
	@RequiresPermissions("pdd:pddSkuListAdd:remove")
	@Log(title = "复制商品sku", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddSkuListAddService.deletePddSkuListAddByIds(ids));
	}
	
}
