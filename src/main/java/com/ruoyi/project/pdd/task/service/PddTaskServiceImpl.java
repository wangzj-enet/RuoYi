package com.ruoyi.project.pdd.task.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.pdd.pddExtent.service.IPddExtentService;
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataAdd.service.IPddGoodsDataAddService;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.service.IPddGoodsMainService;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service.IPddGoodsPropertiesAddService;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service.IPddGoodsPropertiesOriginService;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.service.IPddSkuListAddService;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.service.IPddSkuListOriginService;
import com.ruoyi.project.pdd.util.PddAnalysisUtils;
import com.ruoyi.project.pdd.util.PddCopyUtils;
import com.ruoyi.project.pdd.util.PddMainStatusEnum;
import com.ruoyi.project.pdd.util.PddStatusEnum;
import com.ruoyi.project.system.files.service.IFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

/**
 * 定时任务 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class PddTaskServiceImpl implements IPddTaskService {
	@Autowired
	private IPddGoodsMainService pddGoodsMainService;

	@Autowired
	private IPddGoodsDownloadService pddGoodsDownloadService;
	@Autowired
	private IPddExtentService pddExtentService;
	@Autowired
	private IPddGoodsDataOriginService pddGoodsDataOriginService;
	@Autowired
	private IPddGoodsPropertiesOriginService pddGoodsPropertiesOriginService;
	@Autowired
	private IPddSkuListOriginService pddSkuListOriginService;

	@Autowired
	private IPddGoodsDataAddService pddGoodsDataAddService;
	@Autowired
	private IPddGoodsPropertiesAddService pddGoodsPropertiesAddService;
	@Autowired
	private IPddSkuListAddService pddSkuListAddService;

	@Autowired
	private IFilesService filesService;


	/**
	 * 有参数下载
	 * @param params
	 */
	@Override
	public void downLoadByParams(String params) {
		PddGoodsMain pddGoodsMain =  pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
		if(PddMainStatusEnum.INIT.getCode().equals(pddGoodsMain.getStatus())){
			downLoadJsonDataToInsert(pddGoodsMain);
		}
	}
	/**
	 * 无参数下载
	 */
	@Override
	public void downLoadByNoParams() {
		PddGoodsMain pddGoodsMain = new PddGoodsMain();
		pddGoodsMain.setStatus(PddMainStatusEnum.INIT.getCode());
		List<PddGoodsMain> list =  pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		for(PddGoodsMain pddGoodsMain2 : list){
			downLoadJsonDataToInsert(pddGoodsMain2);
		}
	}

	/**
	 * 根据参数解析
	 * @param params
	 */
	@Override
	public void analysisByParams(String params) {
		PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));

		if (PddMainStatusEnum.DOWNLOAD.getCode().equals(pddGoodsMain.getStatus())) {
			PddGoodsDownload pddGoodsDownload = new PddGoodsDownload();
			pddGoodsDownload.setMainId(pddGoodsMain.getMainId());
			pddGoodsDownload.setStatus(PddStatusEnum.INIT.getCode());
			List<PddGoodsDownload> pddGoodsDownloadList = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
			if(pddGoodsDownloadList.size() > 0){
				pddGoodsDownload = pddGoodsDownloadList.get(0);
				//数据映射开始
				String jsonData = pddGoodsDownload.getGoodsJson();
				JsonToBeanToInsert(jsonData,pddGoodsDownload);
			}

		}
	}

	/**
	 * 无参数解析
	 */
	@Override
	public void analysisByNoParams() {
		PddGoodsMain pddGoodsMain = new PddGoodsMain();
		pddGoodsMain.setStatus(PddMainStatusEnum.DOWNLOAD.getCode());
		List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
			PddGoodsDownload pddGoodsDownload = new PddGoodsDownload();
			pddGoodsDownload.setStatus(PddStatusEnum.INIT.getCode());
			pddGoodsDownload.setMainId(pddGoodsMain2.getMainId());
			List<PddGoodsDownload>  list = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
			if (list.size() == 1) {
				pddGoodsDownload = list.get(0);
				//数据映射开始
				String jsonData = pddGoodsDownload.getGoodsJson();
				JsonToBeanToInsert(jsonData,pddGoodsDownload);

			}
		}
	}


	/**
	 * 有参数Copy
	 * @param params
	 */
	@Override
	public void copyByParams(String params) {
		//根据main查找数据，根据状态判断，关联到解析主表，解析主表到copy主表，sku表，属性表，添加状态表，修改主表状态,修改原始数据状态
		PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
		if(PddMainStatusEnum.ANALYSIS.getCode().equals(pddGoodsMain.getStatus())){
			copyFromGoodsMain(pddGoodsMain);
		}
	}




	/**
	 * 无参数Copy
	 */
	@Override
	public void copyByNoParams() {
		//根据状态查找主表，关联到解析主表，解析主表到copy主表，sku表，属性表，添加状态表，修改主表状态
		PddGoodsMain pddGoodsMain = new PddGoodsMain();
		pddGoodsMain.setStatus(PddMainStatusEnum.ANALYSIS.getCode());
		List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
			copyFromGoodsMain(pddGoodsMain2);
		}
	}

	/**
	 * 有参本地化
	 * @param params
	 */
	@Override
	public void localByParams(String params) {
		//查询主记录，判断主记录状态是否可用，查询copy主表，sku表，properties表，生成本地化url，保存
		PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
		if(PddMainStatusEnum.COPY.getCode().equals(pddGoodsMain.getStatus())){
			localFromPddGoodsMain(pddGoodsMain);

		}
	}

	/**
	 * 无参 本地化
	 */
	@Override
	public void localByNoParams() {
		PddGoodsMain pddGoodsMain = new PddGoodsMain();
		pddGoodsMain.setStatus(PddMainStatusEnum.COPY.getCode());
		List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
			localFromPddGoodsMain(pddGoodsMain2);
		}
	}

	/**
	 * 有参规则化
	 * @param params
	 */
	@Override
	public void ruleByParams(String params) {
		//查询主记录，判断主记录状态是否可用，查询copy主表，sku表，properties表，生成本地化url，保存
		PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
		if(PddMainStatusEnum.LOCAL.getCode().equals(pddGoodsMain.getStatus())){
			ruleFromPddGoodsMain(pddGoodsMain);

		}
	}

	/**
	 * 无参 规则化
	 */
	@Override
	public void ruleByNoParams() {
		PddGoodsMain pddGoodsMain = new PddGoodsMain();
		pddGoodsMain.setStatus(PddMainStatusEnum.LOCAL.getCode());
		List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
		for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
			ruleFromPddGoodsMain(pddGoodsMain2);
		}
	}


	/**
	 * 对数据进行规则话
	 * @param pddGoodsMain
	 */
	private void ruleFromPddGoodsMain(PddGoodsMain pddGoodsMain) {
		System.out.println(pddGoodsMain.toString());
		//查询本地化数据（主表，sku，properties）,查询规则，规则数据
		PddGoodsDataAdd pddGoodsDataAdd = new PddGoodsDataAdd();
		pddGoodsDataAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsDataAdd.setMainId(pddGoodsMain.getMainId());
		List<PddGoodsDataAdd> pddGoodsDataAddList = pddGoodsDataAddService.selectPddGoodsDataAddList(pddGoodsDataAdd);
		if(pddGoodsDataAddList.size() == 1){
			pddGoodsDataAdd = pddGoodsDataAddList.get(0);

			Long mainId = pddGoodsDataAdd.getMainId();
			Long goodsDataAddId = pddGoodsDataAdd.getGoodsDataAddId();

			pddGoodsDataAdd = toRulePddGoodsAdd(pddGoodsDataAdd);
			List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = toRulePddGoodsPropertiesAdds(mainId, goodsDataAddId);
			List<PddSkuListAdd> pddSkuListAddList = toRulePddSkuListAdd(mainId, goodsDataAddId);

			pddExtentService.updatePddGoodsAdds(pddGoodsDataAdd,pddSkuListAddList,pddGoodsPropertiesAddList,PddStatusEnum.END,PddMainStatusEnum.RULE);

		}
	}


	/**
	 * 根据PddGoodsMain下载json数据
	 * @param pddGoodsMain
	 */
	private void downLoadJsonDataToInsert(PddGoodsMain pddGoodsMain) {
		System.out.println(pddGoodsMain.toString());
		//添加status表记录
		//添加download表记录
		//修改主表记录状态
	}


	private void JsonToBeanToInsert(String jsonData,PddGoodsDownload pddGoodsDownload) {
		JSONObject obj = JSONUtil.parseObj(jsonData);
		PddGoodsDataOrigin pddGoodsDataOrigin = PddAnalysisUtils.JsonToBeanPddGoodsDataOrigin(obj);
		List<PddSkuListOrigin> pddSkuListOriginList = PddAnalysisUtils.JsonToBeanPddSkuListOriginList(obj);
		List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = PddAnalysisUtils.JsonToBeanPddGoodsPropertiesOriginList(obj);
		//(单独事务)
		pddExtentService.insertPddGoodsOrigin(pddGoodsDataOrigin, pddSkuListOriginList, pddGoodsPropertiesOriginList,pddGoodsDownload);
		//(单独事务)
		pddGoodsDownload.setStatus(PddStatusEnum.END.getCode());
		pddGoodsDownload.setRemark(PddStatusEnum.END.getDesc());
		pddGoodsDownloadService.updatePddGoodsDownload(pddGoodsDownload);
	}

	/**
	 * 根据pddGoodsMain 数据进行复制
	 * @param pddGoodsMain
	 */
	private void copyFromGoodsMain(PddGoodsMain pddGoodsMain) {
		PddGoodsDataOrigin pddGoodsDataOrigin = new PddGoodsDataOrigin();
		pddGoodsDataOrigin.setMainId(pddGoodsMain.getMainId());
		pddGoodsDataOrigin.setStatus(PddStatusEnum.INIT.getCode());
		List<PddGoodsDataOrigin> pddGoodsDataOriginList = pddGoodsDataOriginService.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
		if(pddGoodsDataOriginList.size() == 1){
			pddGoodsDataOrigin = pddGoodsDataOriginList.get(0);
			Long mainId = pddGoodsDataOrigin.getMainId();
			Long goodsDataOriginId = pddGoodsDataOrigin.getGoodsDataOriginId();

			PddGoodsDataAdd pddGoodsDataAdd = PddCopyUtils.originToAddForData(pddGoodsDataOrigin);

			List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = getPddGoodsPropertiesOrigins(mainId, goodsDataOriginId);
			List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = PddCopyUtils.originToAddForProperties(pddGoodsPropertiesOriginList);

			List<PddSkuListOrigin> pddSkuListOriginList = getPddSkuListOrigins(mainId, goodsDataOriginId);
			List<PddSkuListAdd> pddSkuListAddList = PddCopyUtils.originToAddForSkuList(pddSkuListOriginList);
			//插入动作(单独事务)
			pddExtentService.insertPddGoodsAdd(pddGoodsDataAdd,pddSkuListAddList,pddGoodsPropertiesAddList);
			//更新解析表状态(单独事务)
			pddExtentService.updateGoodsOrigin(pddGoodsDataOrigin,pddSkuListOriginList,pddGoodsPropertiesOriginList,PddStatusEnum.END);

		}
	}

	/**
	 * 根据Origin生成add for Properties
	 * @param mainId
	 * @param goodsDataOriginId
	 * @return
	 */
	private List<PddGoodsPropertiesAdd> originToAddForProperties(Long mainId, Long goodsDataOriginId) {

		List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = getPddGoodsPropertiesOrigins(mainId, goodsDataOriginId);
		return PddCopyUtils.originToAddForProperties(pddGoodsPropertiesOriginList);
	}

	private List<PddGoodsPropertiesOrigin> getPddGoodsPropertiesOrigins(Long mainId, Long goodsDataOriginId) {
		PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = new PddGoodsPropertiesOrigin();
		pddGoodsPropertiesOrigin.setMainId(mainId);
		pddGoodsPropertiesOrigin.setGoodsDataOriginId(goodsDataOriginId);
		pddGoodsPropertiesOrigin.setStatus(PddStatusEnum.INIT.getCode());
		return pddGoodsPropertiesOriginService.selectPddGoodsPropertiesOriginList(pddGoodsPropertiesOrigin);
	}


	/**
	 * 根据Origin生成add for skuList
	 * @param mainId
	 * @param goodsDataOriginId
	 * @return
	 */
	private List<PddSkuListAdd> originToAddForSkuList(Long mainId, Long goodsDataOriginId) {

		List<PddSkuListOrigin> pddSkuListOriginList = getPddSkuListOrigins(mainId, goodsDataOriginId);
		return PddCopyUtils.originToAddForSkuList(pddSkuListOriginList);
	}

	private List<PddSkuListOrigin> getPddSkuListOrigins(Long mainId, Long goodsDataOriginId) {
		PddSkuListOrigin pddSkuListOrigin = new PddSkuListOrigin();
		pddSkuListOrigin.setMainId(mainId);
		pddSkuListOrigin.setGoodsDataOriginId(goodsDataOriginId);
		pddSkuListOrigin.setStatus(PddStatusEnum.INIT.getCode());
		return pddSkuListOriginService.selectPddSkuListOriginList(pddSkuListOrigin);
	}


	/**
	 * 根据pddGoodsMain 进行本地化
	 * @param pddGoodsMain
	 */
	private void localFromPddGoodsMain(PddGoodsMain pddGoodsMain) {
		PddGoodsDataAdd pddGoodsDataAdd = new PddGoodsDataAdd();
		pddGoodsDataAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsDataAdd.setMainId(pddGoodsMain.getMainId());
		List<PddGoodsDataAdd> pddGoodsDataAddList = pddGoodsDataAddService.selectPddGoodsDataAddList(pddGoodsDataAdd);
		if(pddGoodsDataAddList.size() == 1){
			pddGoodsDataAdd = pddGoodsDataAddList.get(0);

			Long mainId = pddGoodsDataAdd.getMainId();
			Long goodsDataAddId = pddGoodsDataAdd.getGoodsDataAddId();

			pddGoodsDataAdd = toLocalPddGoodsAdd(pddGoodsDataAdd);
			List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = toLocalPddGoodsPropertiesAdds(mainId, goodsDataAddId);
			List<PddSkuListAdd> pddSkuListAddList = toLocalPddSkuListAdd(mainId, goodsDataAddId);

			pddExtentService.updatePddGoodsAdds(pddGoodsDataAdd,pddSkuListAddList,pddGoodsPropertiesAddList,PddStatusEnum.INIT,PddMainStatusEnum.LOCAL);

		}
	}

	/**
	 * pddGoodsDataAdd本地化
	 * @param pddGoodsDataAdd
	 * @return
	 */
	private PddGoodsDataAdd toLocalPddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd) {
		pddGoodsDataAdd.setLocalImageUrl(imgFromUrlToLocal(pddGoodsDataAdd.getImageUrl(),"商品活动主图"));
		String localCarouselGallery = urlsToLocalsPath(pddGoodsDataAdd.getCarouselGallery().split("\\|"), "CarouselGallery");
		pddGoodsDataAdd.setLocalCarouselGallery(localCarouselGallery);

		String localDetailGallery = urlsToLocalsPath(pddGoodsDataAdd.getDetailGallery().split("\\|"), "DetailGallery");
		pddGoodsDataAdd.setLocalDetailGallery(localDetailGallery);
		return pddGoodsDataAdd;
	}



	/**
	 * PddGoodsPropertiesAdds 本地化
	 * @param mainId
	 * @param goodsDataAddId
	 * @return
	 */
	private List<PddGoodsPropertiesAdd> toLocalPddGoodsPropertiesAdds(Long mainId, Long goodsDataAddId) {
		PddGoodsPropertiesAdd pddGoodsPropertiesAdd = new PddGoodsPropertiesAdd();
		pddGoodsPropertiesAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsPropertiesAdd.setMainId(mainId);
		pddGoodsPropertiesAdd.setGoodsDataAddId(goodsDataAddId);
		List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);
		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd2:pddGoodsPropertiesAddList) {
			pddGoodsPropertiesAdd2.setLocalImgUrl(imgFromUrlToLocal(pddGoodsPropertiesAdd2.getImgUrl(),pddGoodsPropertiesAdd2.getValue()));
		}
		return pddGoodsPropertiesAddList;
	}



	/**
	 * PddSkuListAdd本地化
	 * @param mainId
	 * @param goodsDataAddId
	 * @return
	 */
	private List<PddSkuListAdd> toLocalPddSkuListAdd(Long mainId, Long goodsDataAddId) {
		PddSkuListAdd pddSkuListAdd = new PddSkuListAdd();
		pddSkuListAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddSkuListAdd.setGoodsDataAddId(goodsDataAddId);
		pddSkuListAdd.setMainId(mainId);
		List<PddSkuListAdd> pddSkuListAddList = pddSkuListAddService.selectPddSkuListAddList(pddSkuListAdd);
		for (PddSkuListAdd pddSkuListAdd2:pddSkuListAddList) {
			pddSkuListAdd2.setLocalThumbUrl(imgFromUrlToLocal(pddSkuListAdd2.getThumbUrl(),pddSkuListAdd2.getSpecValue()));

		}
		return pddSkuListAddList;
	}

	/**
	 * pddGoodsDataAdd 规则化
	 * @param pddGoodsDataAdd
	 * @return
	 */
	private PddGoodsDataAdd toRulePddGoodsAdd(PddGoodsDataAdd pddGoodsDataAdd) {
		System.out.println("规则化");
		pddGoodsDataAdd.setMarketPrice(pddGoodsDataAdd.getMarketPrice()+11);
		return pddGoodsDataAdd;
	}
	/**
	 * PddGoodsPropertiesAdds 规则化
	 * @param mainId
	 * @param goodsDataAddId
	 * @return
	 */
	private List<PddGoodsPropertiesAdd> toRulePddGoodsPropertiesAdds(Long mainId, Long goodsDataAddId) {
		PddGoodsPropertiesAdd pddGoodsPropertiesAdd = new PddGoodsPropertiesAdd();
		pddGoodsPropertiesAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddGoodsPropertiesAdd.setMainId(mainId);
		pddGoodsPropertiesAdd.setGoodsDataAddId(goodsDataAddId);
		List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);
		for (PddGoodsPropertiesAdd pddGoodsPropertiesAdd2:pddGoodsPropertiesAddList) {
			System.out.println("规则化");
		}
		return pddGoodsPropertiesAddList;
	}

	/**
	 * PddSkuListAdd 规则化
	 * @param mainId
	 * @param goodsDataAddId
	 * @return
	 */
	private List<PddSkuListAdd> toRulePddSkuListAdd(Long mainId, Long goodsDataAddId) {
		PddSkuListAdd pddSkuListAdd = new PddSkuListAdd();
		pddSkuListAdd.setStatus(PddStatusEnum.INIT.getCode());
		pddSkuListAdd.setGoodsDataAddId(goodsDataAddId);
		pddSkuListAdd.setMainId(mainId);
		List<PddSkuListAdd> pddSkuListAddList = pddSkuListAddService.selectPddSkuListAddList(pddSkuListAdd);
		for (PddSkuListAdd pddSkuListAdd2:pddSkuListAddList) {
			System.out.println("规则化");
			BigDecimal num = new BigDecimal(10);
			pddSkuListAdd2.setMultiPrice(pddSkuListAdd2.getMultiPrice().add(num));
			pddSkuListAdd2.setPrice(pddSkuListAdd2.getPrice().add(num));
			if(pddSkuListAdd2.getQuantity() > 30){
				pddSkuListAdd2.setQuantity(30L);
			}

		}
		return pddSkuListAddList;
	}

	/**
	 * 把网上url图片转换成本地图片
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private String imgFromUrlToLocal(String url,String reName){

		try {
			if(StringUtils.isEmpty(url)){ return "";}
			url = url.split("\\?")[0];
			url = url.replace("//","http://");
			URL urll = new URL(url);
			File file = new File(RuoYiConfig.getUploadPath()+File.separator+"temp"+File.separator+urll.getFile());
			HttpUtil.downloadFile(url,file);
			MultipartFile multipartFile = FileUtils.toMultipartFile(file,reName);
			System.out.println(multipartFile.getName());
			return filesService.insertFilesAndUpload(multipartFile);
		}catch (Exception e){
			System.out.println(e.getStackTrace());
		}
		return "";
	}


	/**
	 * 批量处理url转换
	 * @param urlArray
	 * @param parentName
	 * @return
	 */
	private String urlsToLocalsPath(String[] urlArray, String parentName) {
		StringBuffer imgSu = new StringBuffer();
		if(urlArray == null){
			return "";
		}
		int i = 0;
		for (String url :urlArray) {
			i += 1;
			String localPath = imgFromUrlToLocal(url,parentName+"_"+i);
			if(StringUtils.isNotEmpty(localPath)){
				imgSu.append(localPath);
				imgSu.append("|");
			}
		}
		return StringUtils.lastNameBefore(imgSu.toString(),"|");
	}


}
