package com.ruoyi.project.pdd.pddSkuListAdd.mapper;

import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import java.util.List;	

/**
 * 复制商品sku 数据层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface PddSkuListAddMapper 
{
	/**
     * 查询复制商品sku信息
     * 
     * @param skuListAddId 复制商品skuID
     * @return 复制商品sku信息
     */
	public PddSkuListAdd selectPddSkuListAddById(Long skuListAddId);
	
	/**
     * 查询复制商品sku列表
     * 
     * @param pddSkuListAdd 复制商品sku信息
     * @return 复制商品sku集合
     */
	public List<PddSkuListAdd> selectPddSkuListAddList(PddSkuListAdd pddSkuListAdd);
	
	/**
     * 新增复制商品sku
     * 
     * @param pddSkuListAdd 复制商品sku信息
     * @return 结果
     */
	public int insertPddSkuListAdd(PddSkuListAdd pddSkuListAdd);
	
	/**
     * 修改复制商品sku
     * 
     * @param pddSkuListAdd 复制商品sku信息
     * @return 结果
     */
	public int updatePddSkuListAdd(PddSkuListAdd pddSkuListAdd);
	
	/**
     * 删除复制商品sku
     * 
     * @param skuListAddId 复制商品skuID
     * @return 结果
     */
	public int deletePddSkuListAddById(Long skuListAddId);
	
	/**
     * 批量删除复制商品sku
     * 
     * @param skuListAddIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePddSkuListAddByIds(String[] skuListAddIds);
	
}