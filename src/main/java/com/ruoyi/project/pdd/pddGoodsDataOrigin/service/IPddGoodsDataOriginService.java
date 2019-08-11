package com.ruoyi.project.pdd.pddGoodsDataOrigin.service;

import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;

import java.util.List;

/**
 * 原始商品数据 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddGoodsDataOriginService 
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
	 * 新增
	 * @param pddGoodsDataOrigin
	 * @param pddSkuListOriginList
	 * @param pddGoodsPropertiesOriginList
	 * @return
	 */
	public int insertPddGoodsOrigin(PddGoodsDataOrigin pddGoodsDataOrigin, List<PddSkuListOrigin> pddSkuListOriginList, List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList, PddGoodsDownload pddGoodsDownload);



	
	/**
     * 修改原始商品数据
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 结果
     */
	public int updatePddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin);
		
	/**
     * 删除原始商品数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDataOriginByIds(String ids);
	
}
