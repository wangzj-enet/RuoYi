package com.ruoyi.project.pdd.pddSkuListAdd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddSkuListAdd.mapper.PddSkuListAddMapper;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.service.IPddSkuListAddService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品SKU 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class PddSkuListAddServiceImpl implements IPddSkuListAddService 
{
	@Autowired
	private PddSkuListAddMapper pddSkuListAddMapper;

	/**
     * 查询商品SKU信息
     * 
     * @param skuListAddId 商品SKUID
     * @return 商品SKU信息
     */
    @Override
	public PddSkuListAdd selectPddSkuListAddById(Long skuListAddId)
	{
	    return pddSkuListAddMapper.selectPddSkuListAddById(skuListAddId);
	}
	
	/**
     * 查询商品SKU列表
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 商品SKU集合
     */
	@Override
	public List<PddSkuListAdd> selectPddSkuListAddList(PddSkuListAdd pddSkuListAdd)
	{
	    return pddSkuListAddMapper.selectPddSkuListAddList(pddSkuListAdd);
	}
	
    /**
     * 新增商品SKU
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 结果
     */
	@Override
	public int insertPddSkuListAdd(PddSkuListAdd pddSkuListAdd)
	{
	    return pddSkuListAddMapper.insertPddSkuListAdd(pddSkuListAdd);
	}
	
	/**
     * 修改商品SKU
     * 
     * @param pddSkuListAdd 商品SKU信息
     * @return 结果
     */
	@Override
	public int updatePddSkuListAdd(PddSkuListAdd pddSkuListAdd)
	{
	    return pddSkuListAddMapper.updatePddSkuListAdd(pddSkuListAdd);
	}

	/**
     * 删除商品SKU对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddSkuListAddByIds(String ids)
	{
		return pddSkuListAddMapper.deletePddSkuListAddByIds(Convert.toStrArray(ids));
	}
	
}
