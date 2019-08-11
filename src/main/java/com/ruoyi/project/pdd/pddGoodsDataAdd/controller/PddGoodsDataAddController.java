package com.ruoyi.project.pdd.pddGoodsDataAdd.controller;

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
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataAdd.service.IPddGoodsDataAddService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 商品数据信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Controller
@RequestMapping("/pdd/pddGoodsDataAdd")
public class PddGoodsDataAddController extends BaseController
{
    private String prefix = "pdd/pddGoodsDataAdd";
	
	@Autowired
	private IPddGoodsDataAddService pddGoodsDataAddService;
	
	@RequiresPermissions("pdd:pddGoodsDataAdd:view")
	@GetMapping()
	public String pddGoodsDataAdd()
	{
	    return prefix + "/pddGoodsDataAdd";
	}
	
	/**
	 * 查询商品数据列表
	 */
	@RequiresPermissions("pdd:pddGoodsDataAdd:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsDataAdd pddGoodsDataAdd)
	{
		startPage();
        List<PddGoodsDataAdd> list = pddGoodsDataAddService.selectPddGoodsDataAddList(pddGoodsDataAdd);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品数据列表
	 */
	@RequiresPermissions("pdd:pddGoodsDataAdd:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsDataAdd pddGoodsDataAdd)
    {
    	List<PddGoodsDataAdd> list = pddGoodsDataAddService.selectPddGoodsDataAddList(pddGoodsDataAdd);
        ExcelUtil<PddGoodsDataAdd> util = new ExcelUtil<PddGoodsDataAdd>(PddGoodsDataAdd.class);
        return util.exportExcel(list, "pddGoodsDataAdd");
    }
	
	/**
	 * 新增商品数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品数据
	 */
	@RequiresPermissions("pdd:pddGoodsDataAdd:add")
	@Log(title = "商品数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsDataAdd pddGoodsDataAdd)
	{		
		return toAjax(pddGoodsDataAddService.insertPddGoodsDataAdd(pddGoodsDataAdd));
	}

	/**
	 * 修改商品数据
	 */
	@GetMapping("/edit/{goodsDataAddId}")
	public String edit(@PathVariable("goodsDataAddId") Long goodsDataAddId, ModelMap mmap)
	{
		PddGoodsDataAdd pddGoodsDataAdd = pddGoodsDataAddService.selectPddGoodsDataAddById(goodsDataAddId);
		mmap.put("pddGoodsDataAdd", pddGoodsDataAdd);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品数据
	 */
	@RequiresPermissions("pdd:pddGoodsDataAdd:edit")
	@Log(title = "商品数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsDataAdd pddGoodsDataAdd)
	{		
		return toAjax(pddGoodsDataAddService.updatePddGoodsDataAdd(pddGoodsDataAdd));
	}
	
	/**
	 * 删除商品数据
	 */
	@RequiresPermissions("pdd:pddGoodsDataAdd:remove")
	@Log(title = "商品数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsDataAddService.deletePddGoodsDataAddByIds(ids));
	}
	
}
