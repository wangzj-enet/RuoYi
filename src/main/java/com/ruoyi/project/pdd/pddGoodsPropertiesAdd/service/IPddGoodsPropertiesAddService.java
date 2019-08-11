package com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service;

import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import java.util.List;

/**
 * 商品属性 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddGoodsPropertiesAddService 
{
	/**
     * 查询商品属性信息
     * 
     * @param goodsPropertiesAddId 商品属性ID
     * @return 商品属性信息
     */
	public PddGoodsPropertiesAdd selectPddGoodsPropertiesAddById(Long goodsPropertiesAddId);
	
	/**
     * 查询商品属性列表
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 商品属性集合
     */
	public List<PddGoodsPropertiesAdd> selectPddGoodsPropertiesAddList(PddGoodsPropertiesAdd pddGoodsPropertiesAdd);
	
	/**
     * 新增商品属性
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 结果
     */
	public int insertPddGoodsPropertiesAdd(PddGoodsPropertiesAdd pddGoodsPropertiesAdd);
	
	/**
     * 修改商品属性
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 结果
     */
	public int updatePddGoodsPropertiesAdd(PddGoodsPropertiesAdd pddGoodsPropertiesAdd);
		
	/**
     * 删除商品属性信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsPropertiesAddByIds(String ids);
	
}
