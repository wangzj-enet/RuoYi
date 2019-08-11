package com.ruoyi.project.pdd.pddExtent.controller;


import com.ruoyi.project.pdd.pddGoodsDownload.controller.PddGoodsDownloadController;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 原商品数据下载信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
public class PddGoodsDownloadExtentController extends PddGoodsDownloadController
{

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long downloadId, ModelMap mmap)
	{
		PddGoodsDownload pddGoodsDownload = pddGoodsDownloadService.selectPddGoodsDownloadById(downloadId);
		mmap.put("pddGoodsDownload", pddGoodsDownload);
		return prefix + "/detail";
	}
	
}
