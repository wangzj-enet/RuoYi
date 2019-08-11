package com.ruoyi.project.pdd.pddSkuListAdd.service;

import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import java.util.List;

/**
 * 商品SKU 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddSkuListAddService 
{
	/**
     * 查询商品SKU信息
     * 
     * @param skuListAddId 商品SKUID
     * @return 商品SKU信息
     */
	public PddSkuListAdd selectPddSkuListAddById(Long skuListAddId);
	
	/**
     * 查询商品SKU列表
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 商品SKU集合
     */
	public List<PddSkuListAdd> selectPddSkuListAddList(PddSkuListAdd pddSkuListAdd);
	
	/**
     * 新增商品SKU
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 结果
     */
	public int insertPddSkuListAdd(PddSkuListAdd pddSkuListAdd);
	
	/**
     * 修改商品SKU
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 结果
     */
	public int updatePddSkuListAdd(PddSkuListAdd pddSkuListAdd);
		
	/**
     * 删除商品SKU信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddSkuListAddByIds(String ids);
	
}
