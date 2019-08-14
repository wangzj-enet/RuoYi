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
import com.ruoyi.project.pdd.util.PddMainStatusEnum;
import com.ruoyi.project.pdd.util.PddStatusEnum;
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
		Long mainId = pddGoodsDownload.getMainId();
		Long goodsId = pddGoodsDownload.getGoodsId();
		String jsonData = "";
		DateTime startTime = new DateTime();

		pddGoodsDataOrigin.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsDataOrigin.setMainId(mainId);
		pddGoodsDataOrigin.setGoodsId(goodsId);
		int i = pddGoodsDataOriginMapper.insertPddGoodsDataOrigin(pddGoodsDataOrigin);
		for (PddSkuListOrigin pddSkuListOrigin : pddSkuListOriginList) {
			pddSkuListOrigin.setMainId(mainId);
			pddSkuListOrigin.setGoodsId(goodsId);
			pddSkuListOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddSkuListOrigin.setStatus(PddStatusEnum.INIT.getCode());
			pddSkuListOriginMapper.insertPddSkuListOrigin(pddSkuListOrigin);
		}

		for (PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin : pddGoodsPropertiesOriginList) {
			pddGoodsPropertiesOrigin.setMainId(mainId);
			pddGoodsPropertiesOrigin.setGoodsId(goodsId);
			pddGoodsPropertiesOrigin.setGoodsDataOriginId(pddGoodsDataOrigin.getGoodsDataOriginId());
			pddGoodsPropertiesOrigin.setStatus(PddStatusEnum.INIT.getCode());
			pddGoodsPropertiesOriginMapper.insertPddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
		}

		//更新主表状态，添加状态表数据
		updataGoodsStatusByEnum(mainId, PddMainStatusEnum.ANALYSIS, startTime,jsonData);
		return i;
	}

	/**
	 * 更新主表状态，添加状态表数据
	 * @param mainId
	 * @param pddMainStatusEnum
	 * @param startTime
	 * @param jsonData
	 */
	private void updataGoodsStatusByEnum(Long mainId, PddMainStatusEnum pddMainStatusEnum, DateTime startTime,String jsonData){
		String status = pddMainStatusEnum.getCode();
		String remark = pddMainStatusEnum.getDesc();
		updataGoodsStatus(mainId,status,startTime,jsonData, remark);
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
		pddGoodsMainStatus.setStatus(PddStatusEnum.INIT.getCode());
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
		Long mainId = pddGoodsDataAdd.getMainId();
		DateTime startTime = new DateTime();

		updateGoodsOrigin(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		int i = insertGoodsAdd(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);

		String jsonData = getJSONStr(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		//更新主表状态，添加状态表数据
		updataGoodsStatusByEnum(mainId, PddMainStatusEnum.COPY, startTime,jsonData);
		return i;
	}


	/**
	 * 更新数据
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updatePddGoodsAdds(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList,PddStatusEnum pddStatusEnum,PddMainStatusEnum pddMainStatusEnum)
	{

		//修改原来对象状态-主表，原数据主表，原数据sku，原数据属性，新数据处理-新数据主表，新数据sku，新数据属性，添加对象状态
		Long mainId = pddGoodsDataAdd.getMainId();
		DateTime startTime = new DateTime();

		int i = updateGoodsAdd(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList,pddStatusEnum);

		String jsonData = getJSONStr(pddGoodsDataAdd, pddSkuListAddList, pddGoodsPropertiesAddList);
		//更新主表状态，添加状态表数据
		updataGoodsStatusByEnum(mainId, pddMainStatusEnum, startTime,jsonData);
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
		PddGoodsDataAddExtent pddGoodsDataAddExtent = new PddGoodsDataAddExtent();
		pddGoodsDataAddExtent.setPddGoodsDataAdd(pddGoodsDataAdd);
		pddGoodsDataAddExtent.setPddGoodsPropertiesAddList(pddGoodsPropertiesAddList);
		pddGoodsDataAddExtent.setPddSkuListAddlist(pddSkuListAddList);
		JSON json = JSONUtil.parse(pddGoodsDataAddExtent);
		String jsonData = json.toString();
		return jsonData;
	}

	/**
	 * 做更新动作
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	private int updateGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList,PddStatusEnum pddStatusEnum) {

		pddGoodsDataAdd.setStatus(pddStatusEnum.getCode());
		pddGoodsDataAdd.setRemark(pddStatusEnum.getDesc());
		int i = pddGoodsDataAddMapper.updatePddGoodsDataAdd(pddGoodsDataAdd);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			pddSkuListAdd.setStatus(pddStatusEnum.getCode());
			pddSkuListAdd.setRemark(pddStatusEnum.getDesc());
			pddSkuListAddMapper.updatePddSkuListAdd(pddSkuListAdd);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			pddGoodsPropertiesAdd.setStatus(pddStatusEnum.getCode());
			pddGoodsPropertiesAdd.setRemark(pddStatusEnum.getDesc());
			pddGoodsPropertiesAddMapper.updatePddGoodsPropertiesAdd(pddGoodsPropertiesAdd);
		}
		return  i;

	}

	/**
	 * 做首次插入业务
	 * @param pddGoodsDataAdd
	 * @param pddSkuListAddList
	 * @param pddGoodsPropertiesAddList
	 * @return
	 */
	private int insertGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd, List<PddSkuListAdd> pddSkuListAddList, List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {
		pddGoodsDataAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsDataAdd.setGoodsDataAddId(null);
		int i = pddGoodsDataAddMapper.insertPddGoodsDataAdd(pddGoodsDataAdd);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			pddSkuListAdd.setSkuListAddId(null);
			pddSkuListAdd.setStatus(PddStatusEnum.INIT.getCode());
			pddSkuListAdd.setGoodsDataAddId(pddGoodsDataAdd.getGoodsDataAddId());
			pddSkuListAddMapper.insertPddSkuListAdd(pddSkuListAdd);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			pddGoodsPropertiesAdd.setStatus(PddStatusEnum.INIT.getCode());
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
		pddGoodsDataOrigin.setStatus(PddStatusEnum.END.getCode());
		pddGoodsDataOriginMapper.updatePddGoodsDataOrigin(pddGoodsDataOrigin);
		pddGoodsDataAdd.setGoodsDataAddId(null);

		for (PddSkuListAdd pddSkuListAdd:pddSkuListAddList) {
			PddSkuListOrigin pddSkuListOrigin = pddSkuListOriginMapper.selectPddSkuListOriginById(pddSkuListAdd.getSkuListAddId());
			pddSkuListOrigin.setStatus(PddStatusEnum.END.getCode());
			pddSkuListOriginMapper.updatePddSkuListOrigin(pddSkuListOrigin);
			pddSkuListAdd.setSkuListAddId(null);
		}

		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd:pddGoodsPropertiesAddList) {
			PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = pddGoodsPropertiesOriginMapper.selectPddGoodsPropertiesOriginById(pddGoodsPropertiesAdd.getGoodsPropertiesAddId());
			pddGoodsPropertiesOrigin.setStatus(PddStatusEnum.END.getCode());
			pddGoodsPropertiesOriginMapper.updatePddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
			pddGoodsPropertiesAdd.setGoodsPropertiesAddId(null);
		}
	}


	/**
	 * 修改解析数据状态
	 * @param pddGoodsDataOrigin
	 * @param pddSkuListOriginList
	 * @param pddGoodsPropertiesOriginList
	 * @param pddStatusEnum
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateGoodsOrigin(PddGoodsDataOrigin pddGoodsDataOrigin, List<PddSkuListOrigin> pddSkuListOriginList, List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList, PddStatusEnum pddStatusEnum) {
		pddGoodsDataOrigin.setStatus(pddStatusEnum.getCode());
		pddGoodsDataOrigin.setRemark(pddStatusEnum.getDesc());
		pddGoodsDataOriginMapper.updatePddGoodsDataOrigin(pddGoodsDataOrigin);

		for (PddSkuListOrigin pddSkuListOrigin:pddSkuListOriginList) {
			pddSkuListOrigin.setStatus(pddStatusEnum.getCode());
			pddSkuListOrigin.setRemark(pddStatusEnum.getDesc());
			pddSkuListOriginMapper.updatePddSkuListOrigin(pddSkuListOrigin);
		}

		for (PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin:pddGoodsPropertiesOriginList) {
			pddGoodsPropertiesOrigin.setStatus(pddStatusEnum.getCode());
			pddGoodsPropertiesOrigin.setRemark(pddStatusEnum.getDesc());
			pddGoodsPropertiesOriginMapper.updatePddGoodsPropertiesOrigin(pddGoodsPropertiesOrigin);
		}
	}

}
