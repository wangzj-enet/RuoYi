package com.ruoyi.project.pdd.pddGoodsDataOrigin.service;

import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import java.util.List;

/**
 * 原商品数据解析 服务层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface IPddGoodsDataOriginService 
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
     * 删除原商品数据解析信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginByIds(String ids);
	
}
