package com.ruoyi.project.pdd.pddGoodsDataOrigin.mapper;

import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import java.util.List;	

/**
 * 原商品数据解析 数据层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface PddGoodsDataOriginMapper 
{
	/**
     * 查询原商品数据解析信息
     * 
     * @param goodsDataOriginId 原商品数据解析ID
     * @return 原商品数据解析信息
     */
	public PddGoodsDataOrigin selectPddGoodsDataOriginById(Long goodsDataOriginId);
	
	/**
     * 查询原商品数据解析列表
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 原商品数据解析集合
     */
	public List<PddGoodsDataOrigin> selectPddGoodsDataOriginList(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 新增原商品数据解析
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 结果
     */
	public int insertPddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 修改原商品数据解析
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 结果
     */
	public int updatePddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin);
	
	/**
     * 删除原商品数据解析
     * 
     * @param goodsDataOriginId 原商品数据解析ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginById(Long goodsDataOriginId);
	
	/**
     * 批量删除原商品数据解析
     * 
     * @param goodsDataOriginIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginByIds(String[] goodsDataOriginIds);
	
}