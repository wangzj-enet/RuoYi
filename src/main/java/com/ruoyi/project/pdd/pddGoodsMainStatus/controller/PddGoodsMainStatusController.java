package com.ruoyi.project.pdd.pddGoodsMainStatus.controller;

import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.monitor.job.domain.Job;
import com.ruoyi.project.monitor.job.service.IJobService;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.service.IPddGoodsMainStatusService;
import com.ruoyi.project.pdd.util.PddMainStatusEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 主记录状态信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@RequestMapping("/pdd/pddGoodsMainStatus")
public class PddGoodsMainStatusController extends BaseController
{
    protected String prefix = "pdd/pddGoodsMainStatus";
	
	@Autowired
	protected IPddGoodsMainStatusService pddGoodsMainStatusService;
	@Autowired
	private IJobService jobService;
	
	@RequiresPermissions("pdd:pddGoodsMainStatus:view")
	@GetMapping()
	public String pddGoodsMainStatus()
	{
	    return prefix + "/pddGoodsMainStatus";
	}
	
	/**
	 * 查询主记录状态列表
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PddGoodsMainStatus pddGoodsMainStatus)
	{
		startPage();
        List<PddGoodsMainStatus> list = pddGoodsMainStatusService.selectPddGoodsMainStatusList(pddGoodsMainStatus);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出主记录状态列表
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PddGoodsMainStatus pddGoodsMainStatus)
    {
    	List<PddGoodsMainStatus> list = pddGoodsMainStatusService.selectPddGoodsMainStatusList(pddGoodsMainStatus);
        ExcelUtil<PddGoodsMainStatus> util = new ExcelUtil<PddGoodsMainStatus>(PddGoodsMainStatus.class);
        return util.exportExcel(list, "pddGoodsMainStatus");
    }
	
	/**
	 * 新增主记录状态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:add")
	@Log(title = "主记录状态", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PddGoodsMainStatus pddGoodsMainStatus)
	{		
		return toAjax(pddGoodsMainStatusService.insertPddGoodsMainStatus(pddGoodsMainStatus));
	}

	/**
	 * 修改主记录状态
	 */
	@GetMapping("/edit/{mainStatusId}")
	public String edit(@PathVariable("mainStatusId") Long mainStatusId, ModelMap mmap)
	{
		PddGoodsMainStatus pddGoodsMainStatus = pddGoodsMainStatusService.selectPddGoodsMainStatusById(mainStatusId);
		mmap.put("pddGoodsMainStatus", pddGoodsMainStatus);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:edit")
	@Log(title = "主记录状态", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PddGoodsMainStatus pddGoodsMainStatus)
	{		
		return toAjax(pddGoodsMainStatusService.updatePddGoodsMainStatus(pddGoodsMainStatus));
	}
	
	/**
	 * 删除主记录状态
	 */
	@RequiresPermissions("pdd:pddGoodsMainStatus:remove")
	@Log(title = "主记录状态", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pddGoodsMainStatusService.deletePddGoodsMainStatusByIds(ids));
	}


	/**
	 * 任务调度立即执行一次
	 */
	@Log(title = "定时任务", businessType = BusinessType.UPDATE)
	@PostMapping("/run")
	@ResponseBody
	public AjaxResult run(PddGoodsMainStatus pddGoodsMainStatus) throws SchedulerException, TaskException
	{
		Job job = new Job();
		job.setJobGroup("DEFAULT");
		job.setInvokeTarget(statusToInvokeTarget(pddGoodsMainStatus.getMainStatus(), pddGoodsMainStatus.getMainId()));
		job.setStatus("1");
		List<Job> jobList = jobService.selectJobList(job);
		if(jobList != null&&jobList.size()>0){
			job = jobList.get(0);
		}else {
			job.setJobName(PddMainStatusEnum.getDesc(pddGoodsMainStatus.getMainStatus())+"（"+pddGoodsMainStatus.getMainId()+"）");
			job.setCronExpression("0/20 * * * * ?");
			job.setMisfirePolicy("1");
			job.setConcurrent("1");
			jobService.insertJob(job);
		}

		jobService.run(job);
		//jobService.deleteJob(job);
		return success();
	}

	private String statusToInvokeTarget(String status, Long mainId) {
		StringBuffer invokeTargetSu = new StringBuffer();
		invokeTargetSu.append("pddTask.");
		invokeTargetSu.append(statusToNextRunMethodName(status));
		invokeTargetSu.append("('");
		invokeTargetSu.append(mainId);
		invokeTargetSu.append("')");
		return invokeTargetSu.toString();
	}

	private String statusToNextRunMethodName(String status) {
		String method;

		switch(PddMainStatusEnum.getEnum(status)){
			case INIT:
				//下载
				method = "downLoad";
				break;
			case DOWNLOAD:
				//解析
				method = "analysis";
				break;
			case ANALYSIS:
				//复制
				method = "copy";
				break;
			case COPY:
				//本地化
				method = "local";
				break;
			case LOCAL:
				//规则化
				method = "rule";
				break;
			case RULE:
				//结束
				method = "end";
				break;
			default :
				method = "ryParams";
		}
		return method;
	}



	/*INIT("00","标记"),
	DOWNLOAD("01","下载"),
	ANALYSIS("02","解析"),
	COPY("03","复制"),
	LOCAL("04","本地化"),
	RULE("05","规则化"),
	END("10","结束"),
	DISCARD("99","作废");*/


}
