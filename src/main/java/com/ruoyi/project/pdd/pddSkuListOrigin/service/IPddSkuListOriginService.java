package com.ruoyi.project.pdd.pddSkuListOrigin.service;

import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import java.util.List;

/**
 * 原始商品SKU 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddSkuListOriginService 
{
	/**
     * 查询原始商品SKU信息
     * 
     * @param skuListOriginId 原始商品SKUID
     * @return 原始商品SKU信息
     */
	public PddSkuListOrigin selectPddSkuListOriginById(Long skuListOriginId);
	
	/**
     * 查询原始商品SKU列表
     * 
     * @param pddSkuListOrigin 原始商品SKU信息
     * @return 原始商品SKU集合
     */
	public List<PddSkuListOrigin> selectPddSkuListOriginList(PddSkuListOrigin pddSkuListOrigin);
	
	/**
     * 新增原始商品SKU
     * 
     * @param pddSkuListOrigin 原始商品SKU信息
     * @return 结果
     */
	public int insertPddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin);
	
	/**
     * 修改原始商品SKU
     * 
     * @param pddSkuListOrigin 原始商品SKU信息
     * @return 结果
     */
	public int updatePddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin);
		
	/**
     * 删除原始商品SKU信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddSkuListOriginByIds(String ids);
	
}
