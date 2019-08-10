package com.ruoyi.project.pdd.pddGoodsMain.service;

import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import java.util.List;

/**
 * 主记录 服务层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface IPddGoodsMainService 
{
	/**
     * 查询主记录信息
     * 
     * @param mainId 主记录ID
     * @return 主记录信息
     */
	public PddGoodsMain selectPddGoodsMainById(Long mainId);
	
	/**
     * 查询主记录列表
     * 
     * @param pddGoodsMain 主记录信息
     * @return 主记录集合
     */
	public List<PddGoodsMain> selectPddGoodsMainList(PddGoodsMain pddGoodsMain);
	
	/**
     * 新增主记录
     * 
     * @param pddGoodsMain 主记录信息
     * @return 结果
     */
	public int insertPddGoodsMain(PddGoodsMain pddGoodsMain);
	
	/**
     * 修改主记录
     * 
     * @param pddGoodsMain 主记录信息
     * @return 结果
     */
	public int updatePddGoodsMain(PddGoodsMain pddGoodsMain);
		
	/**
     * 删除主记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsMainByIds(String ids);
	
}
