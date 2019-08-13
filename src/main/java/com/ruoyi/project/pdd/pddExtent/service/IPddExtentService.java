package com.ruoyi.project.pdd.pddExtent.service;

import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;

import java.util.List;

/**
 * 原始商品数据 服务层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface IPddExtentService
{


	/**
	 * 新增
	 * @param pddGoodsDataOrigin
	 * @param pddSkuListOriginList
	 * @param pddGoodsPropertiesOriginList
	 * @return
	 */
	public int insertPddGoodsOrigin(PddGoodsDataOrigin pddGoodsDataOrigin, List<PddSkuListOrigin> pddSkuListOriginList, List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList, PddGoodsDownload pddGoodsDownload);


	/**
	 * copy 复制
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	public int insertPddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList);

	/**
	 * copy 修改
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	public int updatePddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList);


}
