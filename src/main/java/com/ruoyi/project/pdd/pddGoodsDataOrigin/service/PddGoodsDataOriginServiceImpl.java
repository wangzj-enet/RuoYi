package com.ruoyi.project.pdd.pddGoodsDataOrigin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.mapper.PddGoodsDataOriginMapper;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 原商品数据解析 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsDataOriginServiceImpl implements IPddGoodsDataOriginService 
{
	@Autowired
	private PddGoodsDataOriginMapper pddGoodsDataOriginMapper;

	/**
     * 查询原商品数据解析信息
     * 
     * @param goodsDataOriginId 原商品数据解析ID
     * @return 原商品数据解析信息
     */
    @Override
	public PddGoodsDataOrigin selectPddGoodsDataOriginById(Long goodsDataOriginId)
	{
	    return pddGoodsDataOriginMapper.selectPddGoodsDataOriginById(goodsDataOriginId);
	}
	
	/**
     * 查询原商品数据解析列表
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 原商品数据解析集合
     */
	@Override
	public List<PddGoodsDataOrigin> selectPddGoodsDataOriginList(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
	}
	
    /**
     * 新增原商品数据解析
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.insertPddGoodsDataOrigin(pddGoodsDataOrigin);
	}
	
	/**
     * 修改原商品数据解析
     * 
     * @param pddGoodsDataOrigin 原商品数据解析信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.updatePddGoodsDataOrigin(pddGoodsDataOrigin);
	}

	/**
     * 删除原商品数据解析对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsDataOriginByIds(String ids)
	{
		return pddGoodsDataOriginMapper.deletePddGoodsDataOriginByIds(Convert.toStrArray(ids));
	}
	
}
