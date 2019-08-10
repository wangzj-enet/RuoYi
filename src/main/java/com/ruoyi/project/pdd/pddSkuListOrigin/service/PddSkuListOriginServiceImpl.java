package com.ruoyi.project.pdd.pddSkuListOrigin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddSkuListOrigin.mapper.PddSkuListOriginMapper;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.service.IPddSkuListOriginService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 原商品sku 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddSkuListOriginServiceImpl implements IPddSkuListOriginService 
{
	@Autowired
	private PddSkuListOriginMapper pddSkuListOriginMapper;

	/**
     * 查询原商品sku信息
     * 
     * @param skuListOriginId 原商品skuID
     * @return 原商品sku信息
     */
    @Override
	public PddSkuListOrigin selectPddSkuListOriginById(Long skuListOriginId)
	{
	    return pddSkuListOriginMapper.selectPddSkuListOriginById(skuListOriginId);
	}
	
	/**
     * 查询原商品sku列表
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 原商品sku集合
     */
	@Override
	public List<PddSkuListOrigin> selectPddSkuListOriginList(PddSkuListOrigin pddSkuListOrigin)
	{
	    return pddSkuListOriginMapper.selectPddSkuListOriginList(pddSkuListOrigin);
	}
	
    /**
     * 新增原商品sku
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 结果
     */
	@Override
	public int insertPddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin)
	{
	    return pddSkuListOriginMapper.insertPddSkuListOrigin(pddSkuListOrigin);
	}
	
	/**
     * 修改原商品sku
     * 
     * @param pddSkuListOrigin 原商品sku信息
     * @return 结果
     */
	@Override
	public int updatePddSkuListOrigin(PddSkuListOrigin pddSkuListOrigin)
	{
	    return pddSkuListOriginMapper.updatePddSkuListOrigin(pddSkuListOrigin);
	}

	/**
     * 删除原商品sku对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddSkuListOriginByIds(String ids)
	{
		return pddSkuListOriginMapper.deletePddSkuListOriginByIds(Convert.toStrArray(ids));
	}
	
}
