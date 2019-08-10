package com.ruoyi.project.pdd.pddGoodsMainStatus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsMainStatus.mapper.PddGoodsMainStatusMapper;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.service.IPddGoodsMainStatusService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 主记录状态 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsMainStatusServiceImpl implements IPddGoodsMainStatusService 
{
	@Autowired
	private PddGoodsMainStatusMapper pddGoodsMainStatusMapper;

	/**
     * 查询主记录状态信息
     * 
     * @param mainStatusId 主记录状态ID
     * @return 主记录状态信息
     */
    @Override
	public PddGoodsMainStatus selectPddGoodsMainStatusById(Long mainStatusId)
	{
	    return pddGoodsMainStatusMapper.selectPddGoodsMainStatusById(mainStatusId);
	}
	
	/**
     * 查询主记录状态列表
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 主记录状态集合
     */
	@Override
	public List<PddGoodsMainStatus> selectPddGoodsMainStatusList(PddGoodsMainStatus pddGoodsMainStatus)
	{
	    return pddGoodsMainStatusMapper.selectPddGoodsMainStatusList(pddGoodsMainStatus);
	}
	
    /**
     * 新增主记录状态
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsMainStatus(PddGoodsMainStatus pddGoodsMainStatus)
	{
	    return pddGoodsMainStatusMapper.insertPddGoodsMainStatus(pddGoodsMainStatus);
	}
	
	/**
     * 修改主记录状态
     * 
     * @param pddGoodsMainStatus 主记录状态信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsMainStatus(PddGoodsMainStatus pddGoodsMainStatus)
	{
	    return pddGoodsMainStatusMapper.updatePddGoodsMainStatus(pddGoodsMainStatus);
	}

	/**
     * 删除主记录状态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsMainStatusByIds(String ids)
	{
		return pddGoodsMainStatusMapper.deletePddGoodsMainStatusByIds(Convert.toStrArray(ids));
	}
	
}
