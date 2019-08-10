package com.ruoyi.project.pdd.pddGoodsDataAdd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsDataAdd.mapper.PddGoodsDataAddMapper;
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataAdd.service.IPddGoodsDataAddService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 复制商品数据 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsDataAddServiceImpl implements IPddGoodsDataAddService 
{
	@Autowired
	private PddGoodsDataAddMapper pddGoodsDataAddMapper;

	/**
     * 查询复制商品数据信息
     * 
     * @param goodsDataAddId 复制商品数据ID
     * @return 复制商品数据信息
     */
    @Override
	public PddGoodsDataAdd selectPddGoodsDataAddById(Long goodsDataAddId)
	{
	    return pddGoodsDataAddMapper.selectPddGoodsDataAddById(goodsDataAddId);
	}
	
	/**
     * 查询复制商品数据列表
     * 
     * @param pddGoodsDataAdd 复制商品数据信息
     * @return 复制商品数据集合
     */
	@Override
	public List<PddGoodsDataAdd> selectPddGoodsDataAddList(PddGoodsDataAdd pddGoodsDataAdd)
	{
	    return pddGoodsDataAddMapper.selectPddGoodsDataAddList(pddGoodsDataAdd);
	}
	
    /**
     * 新增复制商品数据
     * 
     * @param pddGoodsDataAdd 复制商品数据信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsDataAdd(PddGoodsDataAdd pddGoodsDataAdd)
	{
	    return pddGoodsDataAddMapper.insertPddGoodsDataAdd(pddGoodsDataAdd);
	}
	
	/**
     * 修改复制商品数据
     * 
     * @param pddGoodsDataAdd 复制商品数据信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsDataAdd(PddGoodsDataAdd pddGoodsDataAdd)
	{
	    return pddGoodsDataAddMapper.updatePddGoodsDataAdd(pddGoodsDataAdd);
	}

	/**
     * 删除复制商品数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsDataAddByIds(String ids)
	{
		return pddGoodsDataAddMapper.deletePddGoodsDataAddByIds(Convert.toStrArray(ids));
	}
	
}
