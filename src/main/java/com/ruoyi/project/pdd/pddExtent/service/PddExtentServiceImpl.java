package com.ruoyi.project.pdd.pddExtent.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.ruoyi.project.pdd.pddExtent.domain.PddGoodsDataAddExtent;
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataAdd.mapper.PddGoodsDataAddMapper;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.mapper.PddGoodsDataOriginMapper;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.mapper.PddGoodsDownloadMapper;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.mapper.PddGoodsMainMapper;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.mapper.PddGoodsMainStatusMapper;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.mapper.PddGoodsPropertiesAddMapper;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.mapper.PddGoodsPropertiesOriginMapper;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.mapper.PddSkuListAddMapper;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.mapper.PddSkuListOriginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 原始商品数据 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class PddExtentServiceImpl implements IPddExtentService {
	@Autowired
	private PddGoodsDataOriginMapper pddGoodsDataOriginMapper;
	@Autowired
	private PddSkuListOriginMapper pddSkuListOriginMapper;
	@Autowired
	private PddGoodsPropertiesOriginMapper pddGoodsPropertiesOriginMapper;

	@Autowired
	private PddGoodsDataAddMapper pddGoodsDataAddMapper;
	@Autowired
	private PddSkuListAddMapper pddSkuListAddMapper;
	@Autowired
	private PddGoodsPropertiesAddMapper pddGoodsPropertiesAddMapper;

	@Autowired
	private PddGoodsMainMapper pddGoodsMainMapper;
	@Autowired
	private PddGoodsMainStatusMapper pddGoodsMainStatusMapper;

	@Autowired
	private PddGoodsDownloadMapper pddGoodsDownloadMapper;


	/**
	 * 新增原始商品数据 集合
	 *
	 * @param pddGoodsDataOrigin
	 * @param pddSkuListOriginList
	 * @param pddGoodsPropertiesOriginList
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertPddGoodsOrigin(PddGoodsDataOrigin pddGoodsDataOrigin, List<PddSkuListOrigin> pddSkuListOriginList, List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList, PddGoodsDownload pddGoodsDownload) {
		String status = "02";
		String remark = "数据解析";
		Long mainId = pddGoodsDataOrigin.getMainId();
		Long goodsId = pddGoodsDataOrigin.getGoodsId();
		String jsonData = "";
		DateTime startTime = new DateTime();

		pddGoodsDataOrigin.setStatus("00");
		pddGoodsDataOrigin.setMainId(mainId);
		pddGoodsDataOrigin.setGoodsId(goodsId);
		int i = pddGoodsDataOriginMapper.insertPddGoodsDataOrigin(pddGoodsDataOrigin);
		for (PddSkuListOrigin pddSkuListOrigin : pddSkuListOriginList) {
			pddSkuListOrigin.setMainId(mainId);
			pddSkuListOrigin.setGoodsId(goodsId);
			pddSkuListOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddSkuListOrigin.setStatus("00");
			pddSkuListOriginMapper.insertPddSkuListOrigin(pddSkuListOrigin);
		}

		for (PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin : pddGoodsPropertiesOriginList) {
			pddGoodsPropertiesOrigin.setMainId(mainId);
			pddGoodsPropertiesOrigin.setGoodsId(goodsId);
			pddGoodsPropertiesOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddGoodsPropertiesOrigin.setStatus("00");
			pddGoodsPropertiesOriginMapper.insertPddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
		}


		pddGoodsDownload.setStatus("02");
		pddGoodsDownloadMapper.updatePddGoodsDownload(pddGoodsDownload);

		//更新主表状态，添加状态表数据
		updataGoodsStatus(mainId, status, startTime,jsonData, remark);
		return i;
	}

	/**
	 *  更新主表状态，添加状态表数据
	 * @param mainId
	 * @param status
	 * @param startTime
	 * @param remark
	 */
	private void updataGoodsStatus(Long mainId, String status, DateTime startTime,String jsonData, String remark) {
		PddGoodsMain pddGoodsMain = pddGoodsMainMapper.selectPddGoodsMainById(mainId);
		pddGoodsMain.setStatus(status);
		pddGoodsMainMapper.updatePddGoodsMain(pddGoodsMain);

		PddGoodsMainStatus pddGoodsMainStatus = new PddGoodsMainStatus();
		pddGoodsMainStatus.setStartTime(startTime);
		pddGoodsMainStatus.setStatus("00");
		pddGoodsMainStatus.setMainStatus(status);
		pddGoodsMainStatus.setMainId(pddGoodsMain.getMainId());
		pddGoodsMainStatus.setGoodsId(pddGoodsMain.getGoodsId());
		pddGoodsMainStatus.setJsonData(jsonData);
		pddGoodsMainStatus.setEndTime(new DateTime());
		pddGoodsMainStatus.setRemark(remark);
		pddGoodsMainStatusMapper.insertPddGoodsMainStatus(pddGoodsMainStatus);
	}

	/**
	 * copy原始商品数据 数据复制
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertPddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList)
	{

		//修改原来对象状态-主表，原数据主表，原数据sku，原数据属性，新数据处理-新数据主表，新数据sku，新数据属性，添加对象状态
		String status = "03";
		String remark = "数据复制";
		Long mainId = pddGoodsDataAdd.getMainId();
		String jsonData = "";
		DateTime startTime = new DateTime();

		updateGoodsOrigin(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		int i = insertGoodsAdd(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);

		jsonData = getJSONStr(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		//更新主表状态，添加状态表数据
		updataGoodsStatus(mainId, status, startTime,jsonData, remark);

		return i;
	}



	/**
	 * copy原始商品数据 数据复制 更新数据
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updatePddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList)
	{

		//修改原来对象状态-主表，原数据主表，原数据sku，原数据属性，新数据处理-新数据主表，新数据sku，新数据属性，添加对象状态
		String status = "04";
		String remark = "数据本地化";
		Long mainId = pddGoodsDataAdd.getMainId();
		String jsonData = "";
		DateTime startTime = new DateTime();

		int i = updateGoodsAdd(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);

		jsonData = getJSONStr(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		//更新主表状态，添加状态表数据
		updataGoodsStatus(mainId, status, startTime,jsonData, remark);

		return i;
	}

	/**
	 * 生成json 字符串
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	private String getJSONStr(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {
		String jsonData;
		PddGoodsDataAddExtent pddGoodsDataAddExtent = new PddGoodsDataAddExtent();
		pddGoodsDataAddExtent.setPddGoodsDataAdd(pddGoodsDataAdd);
		pddGoodsDataAddExtent.setPddGoodsPropertiesAddList(pddGoodsPropertiesAddList);
		pddGoodsDataAddExtent.setPddSkuListAddlist(pddSkuListAddList);
		JSON json = JSONUtil.parse(pddGoodsDataAddExtent);
		jsonData = json.toString();
		return jsonData;
	}

	private int updateGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {

		int i = pddGoodsDataAddMapper.updatePddGoodsDataAdd(pddGoodsDataAdd);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			pddSkuListAddMapper.updatePddSkuListAdd(pddSkuListAdd);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			pddGoodsPropertiesAddMapper.updatePddGoodsPropertiesAdd(pddGoodsPropertiesAdd);
		}
		return  i;

	}

	private int insertGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {
		pddGoodsDataAdd.setStatus("00");
		pddGoodsDataAdd.setGoodsDataAddId(null);
		int i = pddGoodsDataAddMapper.insertPddGoodsDataAdd(pddGoodsDataAdd);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			pddSkuListAdd.setSkuListAddId(null);
			pddSkuListAdd.setStatus("00");
			pddSkuListAdd.setGoodsDataAddId(pddGoodsDataAdd.getGoodsDataAddId());
			pddSkuListAddMapper.insertPddSkuListAdd(pddSkuListAdd);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			pddGoodsPropertiesAdd.setStatus("00");
			pddGoodsPropertiesAdd.setGoodsPropertiesAddId(null);
			pddGoodsPropertiesAdd.setGoodsDataAddId(pddGoodsDataAdd.getGoodsDataAddId());
			pddGoodsPropertiesAddMapper.insertPddGoodsPropertiesAdd(pddGoodsPropertiesAdd);
		}
		return  i;

	}

	/**
	 * 修改解析数据状态
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 */
	private void updateGoodsOrigin(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {
		PddGoodsDataOrigin pddGoodsDataOrigin = pddGoodsDataOriginMapper.selectPddGoodsDataOriginById(pddGoodsDataAdd.getGoodsDataAddId());
		pddGoodsDataOrigin.setStatus("02");
		pddGoodsDataOriginMapper.updatePddGoodsDataOrigin(pddGoodsDataOrigin);
		pddGoodsDataAdd.setGoodsDataAddId(null);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			PddSkuListOrigin pddSkuListOrigin = pddSkuListOriginMapper.selectPddSkuListOriginById(pddSkuListAdd.getSkuListAddId());
			pddSkuListOrigin.setStatus("02");
			pddSkuListOriginMapper.updatePddSkuListOrigin(pddSkuListOrigin);
			pddSkuListAdd.setSkuListAddId(null);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = pddGoodsPropertiesOriginMapper.selectPddGoodsPropertiesOriginById(pddGoodsPropertiesAdd.getGoodsPropertiesAddId());
			pddGoodsPropertiesOrigin.setStatus("02");
			pddGoodsPropertiesOriginMapper.updatePddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
			pddGoodsPropertiesAdd.setGoodsPropertiesAddId(null);
		}
	}

}
