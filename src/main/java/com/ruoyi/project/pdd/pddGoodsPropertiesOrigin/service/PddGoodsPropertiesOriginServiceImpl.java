package com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.mapper.PddGoodsPropertiesOriginMapper;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service.IPddGoodsPropertiesOriginService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 原商品属性 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsPropertiesOriginServiceImpl implements IPddGoodsPropertiesOriginService 
{
	@Autowired
	private PddGoodsPropertiesOriginMapper pddGoodsPropertiesOriginMapper;

	/**
     * 查询原商品属性信息
     * 
     * @param goodsPropertiesOriginId 原商品属性ID
     * @return 原商品属性信息
     */
    @Override
	public PddGoodsPropertiesOrigin selectPddGoodsPropertiesOriginById(Long goodsPropertiesOriginId)
	{
	    return pddGoodsPropertiesOriginMapper.selectPddGoodsPropertiesOriginById(goodsPropertiesOriginId);
	}
	
	/**
     * 查询原商品属性列表
     * 
     * @param pddGoodsPropertiesOrigin 原商品属性信息
     * @return 原商品属性集合
     */
	@Override
	public List<PddGoodsPropertiesOrigin> selectPddGoodsPropertiesOriginList(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{
	    return pddGoodsPropertiesOriginMapper.selectPddGoodsPropertiesOriginList(pddGoodsPropertiesOrigin);
	}
	
    /**
     * 新增原商品属性
     * 
     * @param pddGoodsPropertiesOrigin 原商品属性信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsPropertiesOrigin(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{
	    return pddGoodsPropertiesOriginMapper.insertPddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
	}
	
	/**
     * 修改原商品属性
     * 
     * @param pddGoodsPropertiesOrigin 原商品属性信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsPropertiesOrigin(PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin)
	{
	    return pddGoodsPropertiesOriginMapper.updatePddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
	}

	/**
     * 删除原商品属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsPropertiesOriginByIds(String ids)
	{
		return pddGoodsPropertiesOriginMapper.deletePddGoodsPropertiesOriginByIds(Convert.toStrArray(ids));
	}
	
}
