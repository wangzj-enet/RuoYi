package com.ruoyi.project.pdd.pddGoodsMainStatus.service;

import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import java.util.List;

/**
 * 主记录状态 服务层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface IPddGoodsMainStatusService 
{
	/**
     * 查询主记录状态信息
     * 
     * @param mainStatusId 主记录状态ID
     * @return 主记录状态信息
     */
	public PddGoodsMainStatus selectPddGoodsMainStatusById(Long mainStatusId);
	
	/**
     * 查询主记录状态列表
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 主记录状态集合
     */
	public List<PddGoodsMainStatus> selectPddGoodsMainStatusList(PddGoodsMainStatus pddGoodsMainStatus);
	
	/**
     * 新增主记录状态
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 结果
     */
	public int insertPddGoodsMainStatus(PddGoodsMainStatus pddGoodsMainStatus);
	
	/**
     * 修改主记录状态
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 结果
     */
	public int updatePddGoodsMainStatus(PddGoodsMainStatus pddGoodsMainStatus);
		
	/**
     * 删除主记录状态信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsMainStatusByIds(String ids);
	
}
