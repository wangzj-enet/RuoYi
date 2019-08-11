package com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service;

import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import java.util.List;

/**
 * 原始商品属性 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddGoodsPropertiesOriginService 
{
	/**
     * 查询原始商品属性信息
     * 
     * @param goodsPropertiesOriginId 原始商品属性ID
     * @return 原始商品属性信息
     */
	public PddGoodsPropertiesOrigin selectPddGoodsPropertiesOriginById(Long goodsPropertiesOriginId);
	
	/**
     * 查询原始商品属性列表
     * 
     * @param pddGoodsPropertiesOrigin 原始商品属性信息
     * @return 原始商品属性集合
     */
	public List<PddGoodsPropertiesOrigin> selectPddGoodsPropertiesOriginList(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin);
	
	/**
     * 新增原始商品属性
     * 
     * @param pddGoodsPropertiesOrigin 原始商品属性信息
     * @return 结果
     */
	public int insertPddGoodsPropertiesOrigin(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin);
	
	/**
     * 修改原始商品属性
     * 
     * @param pddGoodsPropertiesOrigin 原始商品属性信息
     * @return 结果
     */
	public int updatePddGoodsPropertiesOrigin(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin);
		
	/**
     * 删除原始商品属性信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsPropertiesOriginByIds(String ids);
	
}
