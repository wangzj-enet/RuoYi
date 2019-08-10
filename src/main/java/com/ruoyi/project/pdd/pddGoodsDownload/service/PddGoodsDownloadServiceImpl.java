package com.ruoyi.project.pdd.pddGoodsDownload.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.pdd.pddGoodsDownload.mapper.PddGoodsDownloadMapper;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 原商品数据下载 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class PddGoodsDownloadServiceImpl implements IPddGoodsDownloadService 
{
	@Autowired
	private PddGoodsDownloadMapper pddGoodsDownloadMapper;

	/**
     * 查询原商品数据下载信息
     * 
     * @param downloadId 原商品数据下载ID
     * @return 原商品数据下载信息
     */
    @Override
	public PddGoodsDownload selectPddGoodsDownloadById(Long downloadId)
	{
	    return pddGoodsDownloadMapper.selectPddGoodsDownloadById(downloadId);
	}
	
	/**
     * 查询原商品数据下载列表
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 原商品数据下载集合
     */
	@Override
	public List<PddGoodsDownload> selectPddGoodsDownloadList(PddGoodsDownload pddGoodsDownload)
	{
	    return pddGoodsDownloadMapper.selectPddGoodsDownloadList(pddGoodsDownload);
	}
	
    /**
     * 新增原商品数据下载
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 结果
     */
	@Override
	public int insertPddGoodsDownload(PddGoodsDownload pddGoodsDownload)
	{
	    return pddGoodsDownloadMapper.insertPddGoodsDownload(pddGoodsDownload);
	}
	
	/**
     * 修改原商品数据下载
     * 
     * @param pddGoodsDownload 原商品数据下载信息
     * @return 结果
     */
	@Override
	public int updatePddGoodsDownload(PddGoodsDownload pddGoodsDownload)
	{
	    return pddGoodsDownloadMapper.updatePddGoodsDownload(pddGoodsDownload);
	}

	/**
     * 删除原商品数据下载对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePddGoodsDownloadByIds(String ids)
	{
		return pddGoodsDownloadMapper.deletePddGoodsDownloadByIds(Convert.toStrArray(ids));
	}
	
}
