package com.ruoyi.project.pdd.pddGoodsDataOrigin.mapper;

import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import java.util.List;	

/**
 * 原始商品数据 数据层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface PddGoodsDataOriginMapper 
{
	/**
     * 查询原始商品数据信息
     * 
     * @param goodsDataOriginId 原始商品数据ID
     * @return 原始商品数据信息
     */
	public PddGoodsDataOrigin selectPddGoodsDataOriginById(Long goodsDataOriginId);
	
	/**
     * 查询原始商品数据列表
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 原始商品数据集合
     */
	public List<PddGoodsDataOrigin> selectPddGoodsDataOriginList(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 新增原始商品数据
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 结果
     */
	public int insertPddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 修改原始商品数据
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 结果
     */
	public int updatePddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 删除原始商品数据
     * 
     * @param goodsDataOriginId 原始商品数据ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginById(Long goodsDataOriginId);
	
	/**
     * 批量删除原始商品数据
     * 
     * @param goodsDataOriginIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginByIds(String[] goodsDataOriginIds);
	
}