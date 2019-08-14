package com.ruoyi.project.pdd.task.service;

/**
 * 定时任务 服务层
 *
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddTaskService
{
	public void downLoadByParams(String params);
	public void downLoadByNoParams();

	public void analysisByParams(String params);
	public void analysisByNoParams();

	public void copyByParams(String params);
	public void copyByNoParams();

	public void localByParams(String params);
	public void localByNoParams();


    public void ruleByParams(String params);
    public void ruleByNoParams();


}
