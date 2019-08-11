package com.ruoyi.project.pdd.pddGoodsDataOrigin.service;

import java.util.List;

import cn.hutool.core.date.DateTime;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.mapper.PddGoodsMainMapper;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.mapper.PddGoodsMainStatusMapper;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.mapper.PddGoodsPropertiesOriginMapper;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.mapper.PddSkuListOriginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.mapper.PddGoodsDataOriginMapper;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 原始商品数据 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class PddGoodsDataOriginServiceImpl implements IPddGoodsDataOriginService 
{
	@Autowired
	private PddGoodsDataOriginMapper pddGoodsDataOriginMapper;
	@Autowired
	private PddSkuListOriginMapper pddSkuListOriginMapper;
	@Autowired
	private PddGoodsPropertiesOriginMapper pddGoodsPropertiesOriginMapper;

	@Autowired
	private PddGoodsMainMapper pddGoodsMainMapper;
	@Autowired
	private PddGoodsMainStatusMapper pddGoodsMainStatusMapper;

	@Autowired
	private IPddGoodsDownloadService pddGoodsDownloadService;


	/**
     * 查询原始商品数据信息
     * 
     * @param goodsDataOriginId 原始商品数据ID
     * @return 原始商品数据信息
     */
    @Override
	public PddGoodsDataOrigin selectPddGoodsDataOriginById(Long goodsDataOriginId)
	{
	    return pddGoodsDataOriginMapper.selectPddGoodsDataOriginById(goodsDataOriginId);
	}
	
	/**
     * 查询原始商品数据列表
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 原始商品数据集合
     */
	@Override
	public List<PddGoodsDataOrigin> selectPddGoodsDataOriginList(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
	}
	
    /**
     * 新增原始商品数据
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.insertPddGoodsDataOrigin(pddGoodsDataOrigin);
	}

	/**
	 * 新增原始商品数据 集合
	 * @param pddGoodsDataOrigin
	 * @param pddSkuListOriginList
	 * @param pddGoodsPropertiesOriginList
	 * @return
	 */
	@Override
	public int insertPddGoodsOrigin(PddGoodsDataOrigin pddGoodsDataOrigin, List<PddSkuListOrigin> pddSkuListOriginList, List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList, PddGoodsDownload pddGoodsDownload)
	{
		PddGoodsMainStatus pddGoodsMainStatus = new PddGoodsMainStatus();
		pddGoodsMainStatus.setStartTime(new DateTime());
		pddGoodsDataOrigin.setStatus("00");
		pddGoodsDataOrigin.setMainId(pddGoodsDownload.getMainId());
		pddGoodsDataOrigin.setGoodsId(pddGoodsDownload.getGoodsId());
		int i = pddGoodsDataOriginMapper.insertPddGoodsDataOrigin(pddGoodsDataOrigin);
		for (PddSkuListOrigin pddSkuListOrigin:pddSkuListOriginList) {
			pddSkuListOrigin.setMainId(pddGoodsDataOrigin.getMainId());
			pddSkuListOrigin.setGoodsId(pddGoodsDataOrigin.getGoodsId());
			pddSkuListOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddSkuListOrigin.setStatus("00");
			pddSkuListOriginMapper.insertPddSkuListOrigin(pddSkuListOrigin);
		}

		for (PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin:pddGoodsPropertiesOriginList ) {
			pddGoodsPropertiesOrigin.setMainId(pddGoodsDataOrigin.getMainId());
			pddGoodsPropertiesOrigin.setGoodsId(pddGoodsDataOrigin.getGoodsId());
			pddGoodsDataOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddGoodsDataOrigin.setStatus("00");
			pddGoodsPropertiesOriginMapper.insertPddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
		}
		pddGoodsDownload.setStatus("02");
		pddGoodsDownloadService.updatePddGoodsDownload(pddGoodsDownload);

		pddGoodsMainStatus.setStatus("00");
		pddGoodsMainStatus.setMainStatus("02");
		pddGoodsMainStatus.setMainId(pddGoodsDataOrigin.getMainId());
		pddGoodsMainStatus.setGoodsId(pddGoodsDataOrigin.getGoodsId());

		pddGoodsMainStatus.setEndTime(new DateTime());
		pddGoodsMainStatus.setRemark("数据解析");
		pddGoodsMainStatusMapper.insertPddGoodsMainStatus(pddGoodsMainStatus);

		PddGoodsMain pddGoodsMain = pddGoodsMainMapper.selectPddGoodsMainById(pddGoodsDataOrigin.getMainId());
		pddGoodsMain.setStatus("02");
		pddGoodsMainMapper.updatePddGoodsMain(pddGoodsMain);
		return i;
	}
	
	/**
     * 修改原始商品数据
     * 
     * @param pddGoodsDataOrigin 原始商品数据信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsDataOrigin(PddGoodsDataOrigin pddGoodsDataOrigin)
	{
	    return pddGoodsDataOriginMapper.updatePddGoodsDataOrigin(pddGoodsDataOrigin);
	}

	/**
     * 删除原始商品数据对象
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
