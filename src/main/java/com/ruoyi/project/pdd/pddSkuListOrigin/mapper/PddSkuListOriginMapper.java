package com.ruoyi.project.pdd.pddSkuListOrigin.mapper;

import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import java.util.List;	

/**
 * 原商品sku 数据层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface PddSkuListOriginMapper 
{
	/**
     * 查询原商品sku信息
     * 
     * @param skuListOriginId 原商品skuID
     * @return 原商品sku信息
     */
	public PddSkuListOrigin selectPddSkuListOriginById(Long skuListOriginId);
	
	/**
     * 查询原商品sku列表
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 原商品sku集合
     */
	public List<PddSkuListOrigin> selectPddSkuListOriginList(PddSkuListOrigin pddSkuListOrigin);
	
	/**
     * 新增原商品sku
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 结果
     */
	public int insertPddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin);
	
	/**
     * 修改原商品sku
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 结果
     */
	public int updatePddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin);
	
	/**
     * 删除原商品sku
     * 
     * @param skuListOriginId 原商品skuID
     * @return 结果
     */
	public int deletePddSkuListOriginById(Long skuListOriginId);
	
	/**
     * 批量删除原商品sku
     * 
     * @param skuListOriginIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePddSkuListOriginByIds(String[] skuListOriginIds);
	
}