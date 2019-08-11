package com.ruoyi.project.pdd.pddExtent.controller;


import com.ruoyi.project.pdd.pddGoodsMainStatus.controller.PddGoodsMainStatusController;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 主记录状态信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
public class PddGoodsMainStatusExtentController extends PddGoodsMainStatusController
{

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long mainStatusId, ModelMap mmap)
	{
		PddGoodsMainStatus pddGoodsMainStatus = pddGoodsMainStatusService.selectPddGoodsMainStatusById(mainStatusId);
		mmap.put("pddGoodsMainStatus", pddGoodsMainStatus);
		return prefix + "/detail";
	}
}
