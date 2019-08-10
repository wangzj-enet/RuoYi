package com.ruoyi.project.pdd.pddGoodsMain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsMain.mapper.PddGoodsMainMapper;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.service.IPddGoodsMainService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 主记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsMainServiceImpl implements IPddGoodsMainService 
{
	@Autowired
	private PddGoodsMainMapper pddGoodsMainMapper;

	/**
     * 查询主记录信息
     * 
     * @param mainId 主记录ID
     * @return 主记录信息
     */
    @Override
	public PddGoodsMain selectPddGoodsMainById(Long mainId)
	{
	    return pddGoodsMainMapper.selectPddGoodsMainById(mainId);
	}
	
	/**
     * 查询主记录列表
     * 
     * @param pddGoodsMain 主记录信息
     * @return 主记录集合
     */
	@Override
	public List<PddGoodsMain> selectPddGoodsMainList(PddGoodsMain pddGoodsMain)
	{
	    return pddGoodsMainMapper.selectPddGoodsMainList(pddGoodsMain);
	}
	
    /**
     * 新增主记录
     * 
     * @param pddGoodsMain 主记录信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsMain(PddGoodsMain pddGoodsMain)
	{
	    return pddGoodsMainMapper.insertPddGoodsMain(pddGoodsMain);
	}
	
	/**
     * 修改主记录
     * 
     * @param pddGoodsMain 主记录信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsMain(PddGoodsMain pddGoodsMain)
	{
	    return pddGoodsMainMapper.updatePddGoodsMain(pddGoodsMain);
	}

	/**
     * 删除主记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsMainByIds(String ids)
	{
		return pddGoodsMainMapper.deletePddGoodsMainByIds(Convert.toStrArray(ids));
	}
	
}
