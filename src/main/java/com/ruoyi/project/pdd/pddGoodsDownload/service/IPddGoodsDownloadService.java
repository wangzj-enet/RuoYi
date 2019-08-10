package com.ruoyi.project.pdd.pddGoodsDownload.service;

import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import java.util.List;

/**
 * 原商品数据下载 服务层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface IPddGoodsDownloadService 
{
	/**
     * 查询原商品数据下载信息
     * 
     * @param downloadId 原商品数据下载ID
     * @return 原商品数据下载信息
     */
	public PddGoodsDownload selectPddGoodsDownloadById(Long downloadId);
	
	/**
     * 查询原商品数据下载列表
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 原商品数据下载集合
     */
	public List<PddGoodsDownload> selectPddGoodsDownloadList(PddGoodsDownload pddGoodsDownload);
	
	/**
     * 新增原商品数据下载
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 结果
     */
	public int insertPddGoodsDownload(PddGoodsDownload pddGoodsDownload);
	
	/**
     * 修改原商品数据下载
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 结果
     */
	public int updatePddGoodsDownload(PddGoodsDownload pddGoodsDownload);
		
	/**
     * 删除原商品数据下载信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDownloadByIds(String ids);
	
}
