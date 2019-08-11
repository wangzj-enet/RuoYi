package com.ruoyi.project.pdd.pddGoodsDataAdd.service;

import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import java.util.List;

/**
 * 商品数据 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddGoodsDataAddService 
{
	/**
     * 查询商品数据信息
     * 
     * @param goodsDataAddId 商品数据ID
     * @return 商品数据信息
     */
	public PddGoodsDataAdd selectPddGoodsDataAddById(Long goodsDataAddId);
	
	/**
     * 查询商品数据列表
     * 
     * @param pddGoodsDataAdd 商品数据信息
     * @return 商品数据集合
     */
	public List<PddGoodsDataAdd> selectPddGoodsDataAddList(PddGoodsDataAdd pddGoodsDataAdd);
	
	/**
     * 新增商品数据
     * 
     * @param pddGoodsDataAdd 商品数据信息
     * @return 结果
     */
	public int insertPddGoodsDataAdd(PddGoodsDataAdd pddGoodsDataAdd);
	
	/**
     * 修改商品数据
     * 
     * @param pddGoodsDataAdd 商品数据信息
     * @return 结果
     */
	public int updatePddGoodsDataAdd(PddGoodsDataAdd pddGoodsDataAdd);
		
	/**
     * 删除商品数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePddGoodsDataAddByIds(String ids);
	
}
