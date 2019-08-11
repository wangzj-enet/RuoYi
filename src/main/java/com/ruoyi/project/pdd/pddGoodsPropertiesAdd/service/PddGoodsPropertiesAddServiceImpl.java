package com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.mapper.PddGoodsPropertiesAddMapper;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service.IPddGoodsPropertiesAddService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品属性 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class PddGoodsPropertiesAddServiceImpl implements IPddGoodsPropertiesAddService 
{
	@Autowired
	private PddGoodsPropertiesAddMapper pddGoodsPropertiesAddMapper;

	/**
     * 查询商品属性信息
     * 
     * @param goodsPropertiesAddId 商品属性ID
     * @return 商品属性信息
     */
    @Override
	public PddGoodsPropertiesAdd selectPddGoodsPropertiesAddById(Long goodsPropertiesAddId)
	{
	    return pddGoodsPropertiesAddMapper.selectPddGoodsPropertiesAddById(goodsPropertiesAddId);
	}
	
	/**
     * 查询商品属性列表
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 商品属性集合
     */
	@Override
	public List<PddGoodsPropertiesAdd> selectPddGoodsPropertiesAddList(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{
	    return pddGoodsPropertiesAddMapper.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);
	}
	
    /**
     * 新增商品属性
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsPropertiesAdd(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{
	    return pddGoodsPropertiesAddMapper.insertPddGoodsPropertiesAdd(pddGoodsPropertiesAdd);
	}
	
	/**
     * 修改商品属性
     * 
     * @param pddGoodsPropertiesAdd 商品属性信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsPropertiesAdd(PddGoodsPropertiesAdd pddGoodsPropertiesAdd)
	{
	    return pddGoodsPropertiesAddMapper.updatePddGoodsPropertiesAdd(pddGoodsPropertiesAdd);
	}

	/**
     * 删除商品属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsPropertiesAddByIds(String ids)
	{
		return pddGoodsPropertiesAddMapper.deletePddGoodsPropertiesAddByIds(Convert.toStrArray(ids));
	}
	
}
