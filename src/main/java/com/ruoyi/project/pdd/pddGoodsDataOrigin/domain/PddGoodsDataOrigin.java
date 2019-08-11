package com.ruoyi.project.pdd.pddGoodsDataOrigin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 原始商品数据表 pdd_goods_data_origin
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public class PddGoodsDataOrigin extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long goodsDataOriginId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 三方id */
	private Long thirdId;
	/** 商品标题 */
	private String goodsName;
	/** 商品类型 */
	private Long goodsType;
	/** 商品描述 */
	private String goodsDesc;
	/** 叶子类目ID */
	private Long catId;
	/** 叶子类目ID1 */
	private Long catId1;
	/** 叶子类目ID2 */
	private Long catId2;
	/** 叶子类目ID3 */
	private Long catId3;
	/** 叶子类目ID4 */
	private Long catId4;
	/** 叶子类目名称 */
	private String catName;
	/** 叶子类目名称1 */
	private String catName1;
	/** 叶子类目名称2 */
	private String catName2;
	/** 叶子类目名称3 */
	private String catName3;
	/** 叶子类目名称4 */
	private String catName4;
	/** 商品短标题 */
	private String tinyName;
	/** 国家ID */
	private Long countryId;
	/** 保税仓 */
	private String warehouse;
	/** 报关海关 */
	private String customs;
	/** 是否上报海关 */
	private String isCustoms;
	/** 市场价格 */
	private Long marketPrice;
	/** 是否预售 */
	private String isPreSale;
	/** 预售时间 */
	private Long preSaleTime;
	/** 承诺发货时间（ 秒） */
	private Long shipmentLimitSecond;
	/** 物流运费模板ID */
	private Long costTemplateId;
	/** 团购人数 */
	private Long customerNum;
	/** 限购次数 */
	private Long buyLimit;
	/** 单次限量 */
	private Long orderLimit;
	/** 是否7天无理由退换货 */
	private String isRefundable;
	/** 是否二手商品 */
	private String secondHand;
	/** 是否支持假一赔十 */
	private String isFolt;
	/** 水果类目温馨提示 */
	private String warmTips;
	/** 商品goods外部编码 */
	private String outGoodsId;
	/** 商品活动主图 */
	private String imageUrl;
	/** 商品轮播图 */
	private String carouselGallery;
	/** 商品详情图 */
	private String detailGallery;
	/** 是否支持正品发票 */
	private Long invoiceStatus;
	/** 是否支持全国联保 */
	private Long quanGuoLianBao;
	/** 只换不修的天数 */
	private Long zhiHuanBuXiu;
	/** 送货入户模版id */
	private String songHuoRuHu;
	/** 上门安装模版id */
	private String shangMenAnZhuang;
	/** 送货入户并安装模版id */
	private String songHuoAnZhuang;
	/** 买家自提模版id */
	private String maiJiaZiTi;
	/** 坏果包赔 */
	private Long badFruitClaim;
	/** 缺重包退 */
	private Long lackOfWeightClaim;
	/** 原产地id */
	private Long originCountryId;
	/** sku对象列表 */
	private Long skuListOriginId;
	/** 商品属性列表 */
	private Long goodsPropertiesOriginId;
	/** 海外原id */
	private Long overseaGoodsOriginId;
	/** 商品视频 */
	private Long carouselVideoOriginId;
	/** 商品视频 */
	private String carouselVideoOrigin;
	/** 服务集合 */
	private String mallService;
	/** 承诺发货时间 */
	private String shipmentLimitServer;
	/** 物流运费模板 */
	private String costTemplateServer;
	/** 是否7天无理由退换货 */
	private String refundableServer;
	/** 状态 */
	private String status;
	/** 备注1 */
	private String remark1;
	/** 备注2 */
	private String remark2;
	/** 备注3 */
	private String remark3;
	/** 备注4 */
	private String remark4;
	/** 备注5 */
	private String remark5;

	public void setGoodsDataOriginId(Long goodsDataOriginId) 
	{
		this.goodsDataOriginId = goodsDataOriginId;
	}

	public Long getGoodsDataOriginId() 
	{
		return goodsDataOriginId;
	}
	public void setMainId(Long mainId) 
	{
		this.mainId = mainId;
	}

	public Long getMainId() 
	{
		return mainId;
	}
	public void setGoodsId(Long goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Long getGoodsId() 
	{
		return goodsId;
	}
	public void setThirdId(Long thirdId) 
	{
		this.thirdId = thirdId;
	}

	public Long getThirdId() 
	{
		return thirdId;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsType(Long goodsType) 
	{
		this.goodsType = goodsType;
	}

	public Long getGoodsType() 
	{
		return goodsType;
	}
	public void setGoodsDesc(String goodsDesc) 
	{
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsDesc() 
	{
		return goodsDesc;
	}
	public void setCatId(Long catId) 
	{
		this.catId = catId;
	}

	public Long getCatId() 
	{
		return catId;
	}
	public void setCatId1(Long catId1) 
	{
		this.catId1 = catId1;
	}

	public Long getCatId1() 
	{
		return catId1;
	}
	public void setCatId2(Long catId2) 
	{
		this.catId2 = catId2;
	}

	public Long getCatId2() 
	{
		return catId2;
	}
	public void setCatId3(Long catId3) 
	{
		this.catId3 = catId3;
	}

	public Long getCatId3() 
	{
		return catId3;
	}
	public void setCatId4(Long catId4) 
	{
		this.catId4 = catId4;
	}

	public Long getCatId4() 
	{
		return catId4;
	}
	public void setCatName(String catName) 
	{
		this.catName = catName;
	}

	public String getCatName() 
	{
		return catName;
	}
	public void setCatName1(String catName1) 
	{
		this.catName1 = catName1;
	}

	public String getCatName1() 
	{
		return catName1;
	}
	public void setCatName2(String catName2) 
	{
		this.catName2 = catName2;
	}

	public String getCatName2() 
	{
		return catName2;
	}
	public void setCatName3(String catName3) 
	{
		this.catName3 = catName3;
	}

	public String getCatName3() 
	{
		return catName3;
	}
	public void setCatName4(String catName4) 
	{
		this.catName4 = catName4;
	}

	public String getCatName4() 
	{
		return catName4;
	}
	public void setTinyName(String tinyName) 
	{
		this.tinyName = tinyName;
	}

	public String getTinyName() 
	{
		return tinyName;
	}
	public void setCountryId(Long countryId) 
	{
		this.countryId = countryId;
	}

	public Long getCountryId() 
	{
		return countryId;
	}
	public void setWarehouse(String warehouse) 
	{
		this.warehouse = warehouse;
	}

	public String getWarehouse() 
	{
		return warehouse;
	}
	public void setCustoms(String customs) 
	{
		this.customs = customs;
	}

	public String getCustoms() 
	{
		return customs;
	}
	public void setIsCustoms(String isCustoms) 
	{
		this.isCustoms = isCustoms;
	}

	public String getIsCustoms() 
	{
		return isCustoms;
	}
	public void setMarketPrice(Long marketPrice) 
	{
		this.marketPrice = marketPrice;
	}

	public Long getMarketPrice() 
	{
		return marketPrice;
	}
	public void setIsPreSale(String isPreSale) 
	{
		this.isPreSale = isPreSale;
	}

	public String getIsPreSale() 
	{
		return isPreSale;
	}
	public void setPreSaleTime(Long preSaleTime) 
	{
		this.preSaleTime = preSaleTime;
	}

	public Long getPreSaleTime() 
	{
		return preSaleTime;
	}
	public void setShipmentLimitSecond(Long shipmentLimitSecond) 
	{
		this.shipmentLimitSecond = shipmentLimitSecond;
	}

	public Long getShipmentLimitSecond() 
	{
		return shipmentLimitSecond;
	}
	public void setCostTemplateId(Long costTemplateId) 
	{
		this.costTemplateId = costTemplateId;
	}

	public Long getCostTemplateId() 
	{
		return costTemplateId;
	}
	public void setCustomerNum(Long customerNum) 
	{
		this.customerNum = customerNum;
	}

	public Long getCustomerNum() 
	{
		return customerNum;
	}
	public void setBuyLimit(Long buyLimit) 
	{
		this.buyLimit = buyLimit;
	}

	public Long getBuyLimit() 
	{
		return buyLimit;
	}
	public void setOrderLimit(Long orderLimit) 
	{
		this.orderLimit = orderLimit;
	}

	public Long getOrderLimit() 
	{
		return orderLimit;
	}
	public void setIsRefundable(String isRefundable) 
	{
		this.isRefundable = isRefundable;
	}

	public String getIsRefundable() 
	{
		return isRefundable;
	}
	public void setSecondHand(String secondHand) 
	{
		this.secondHand = secondHand;
	}

	public String getSecondHand() 
	{
		return secondHand;
	}
	public void setIsFolt(String isFolt) 
	{
		this.isFolt = isFolt;
	}

	public String getIsFolt() 
	{
		return isFolt;
	}
	public void setWarmTips(String warmTips) 
	{
		this.warmTips = warmTips;
	}

	public String getWarmTips() 
	{
		return warmTips;
	}
	public void setOutGoodsId(String outGoodsId) 
	{
		this.outGoodsId = outGoodsId;
	}

	public String getOutGoodsId() 
	{
		return outGoodsId;
	}
	public void setImageUrl(String imageUrl) 
	{
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() 
	{
		return imageUrl;
	}
	public void setCarouselGallery(String carouselGallery) 
	{
		this.carouselGallery = carouselGallery;
	}

	public String getCarouselGallery() 
	{
		return carouselGallery;
	}
	public void setDetailGallery(String detailGallery) 
	{
		this.detailGallery = detailGallery;
	}

	public String getDetailGallery() 
	{
		return detailGallery;
	}
	public void setInvoiceStatus(Long invoiceStatus) 
	{
		this.invoiceStatus = invoiceStatus;
	}

	public Long getInvoiceStatus() 
	{
		return invoiceStatus;
	}
	public void setQuanGuoLianBao(Long quanGuoLianBao) 
	{
		this.quanGuoLianBao = quanGuoLianBao;
	}

	public Long getQuanGuoLianBao() 
	{
		return quanGuoLianBao;
	}
	public void setZhiHuanBuXiu(Long zhiHuanBuXiu) 
	{
		this.zhiHuanBuXiu = zhiHuanBuXiu;
	}

	public Long getZhiHuanBuXiu() 
	{
		return zhiHuanBuXiu;
	}
	public void setSongHuoRuHu(String songHuoRuHu) 
	{
		this.songHuoRuHu = songHuoRuHu;
	}

	public String getSongHuoRuHu() 
	{
		return songHuoRuHu;
	}
	public void setShangMenAnZhuang(String shangMenAnZhuang) 
	{
		this.shangMenAnZhuang = shangMenAnZhuang;
	}

	public String getShangMenAnZhuang() 
	{
		return shangMenAnZhuang;
	}
	public void setSongHuoAnZhuang(String songHuoAnZhuang) 
	{
		this.songHuoAnZhuang = songHuoAnZhuang;
	}

	public String getSongHuoAnZhuang() 
	{
		return songHuoAnZhuang;
	}
	public void setMaiJiaZiTi(String maiJiaZiTi) 
	{
		this.maiJiaZiTi = maiJiaZiTi;
	}

	public String getMaiJiaZiTi() 
	{
		return maiJiaZiTi;
	}
	public void setBadFruitClaim(Long badFruitClaim) 
	{
		this.badFruitClaim = badFruitClaim;
	}

	public Long getBadFruitClaim() 
	{
		return badFruitClaim;
	}
	public void setLackOfWeightClaim(Long lackOfWeightClaim) 
	{
		this.lackOfWeightClaim = lackOfWeightClaim;
	}

	public Long getLackOfWeightClaim() 
	{
		return lackOfWeightClaim;
	}
	public void setOriginCountryId(Long originCountryId) 
	{
		this.originCountryId = originCountryId;
	}

	public Long getOriginCountryId() 
	{
		return originCountryId;
	}
	public void setSkuListOriginId(Long skuListOriginId) 
	{
		this.skuListOriginId = skuListOriginId;
	}

	public Long getSkuListOriginId() 
	{
		return skuListOriginId;
	}
	public void setGoodsPropertiesOriginId(Long goodsPropertiesOriginId) 
	{
		this.goodsPropertiesOriginId = goodsPropertiesOriginId;
	}

	public Long getGoodsPropertiesOriginId() 
	{
		return goodsPropertiesOriginId;
	}
	public void setOverseaGoodsOriginId(Long overseaGoodsOriginId) 
	{
		this.overseaGoodsOriginId = overseaGoodsOriginId;
	}

	public Long getOverseaGoodsOriginId() 
	{
		return overseaGoodsOriginId;
	}
	public void setCarouselVideoOriginId(Long carouselVideoOriginId) 
	{
		this.carouselVideoOriginId = carouselVideoOriginId;
	}

	public Long getCarouselVideoOriginId() 
	{
		return carouselVideoOriginId;
	}
	public void setCarouselVideoOrigin(String carouselVideoOrigin) 
	{
		this.carouselVideoOrigin = carouselVideoOrigin;
	}

	public String getCarouselVideoOrigin() 
	{
		return carouselVideoOrigin;
	}
	public void setMallService(String mallService) 
	{
		this.mallService = mallService;
	}

	public String getMallService() 
	{
		return mallService;
	}
	public void setShipmentLimitServer(String shipmentLimitServer) 
	{
		this.shipmentLimitServer = shipmentLimitServer;
	}

	public String getShipmentLimitServer() 
	{
		return shipmentLimitServer;
	}
	public void setCostTemplateServer(String costTemplateServer) 
	{
		this.costTemplateServer = costTemplateServer;
	}

	public String getCostTemplateServer() 
	{
		return costTemplateServer;
	}
	public void setRefundableServer(String refundableServer) 
	{
		this.refundableServer = refundableServer;
	}

	public String getRefundableServer() 
	{
		return refundableServer;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setRemark1(String remark1) 
	{
		this.remark1 = remark1;
	}

	public String getRemark1() 
	{
		return remark1;
	}
	public void setRemark2(String remark2) 
	{
		this.remark2 = remark2;
	}

	public String getRemark2() 
	{
		return remark2;
	}
	public void setRemark3(String remark3) 
	{
		this.remark3 = remark3;
	}

	public String getRemark3() 
	{
		return remark3;
	}
	public void setRemark4(String remark4) 
	{
		this.remark4 = remark4;
	}

	public String getRemark4() 
	{
		return remark4;
	}
	public void setRemark5(String remark5) 
	{
		this.remark5 = remark5;
	}

	public String getRemark5() 
	{
		return remark5;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsDataOriginId", getGoodsDataOriginId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("thirdId", getThirdId())
            .append("goodsName", getGoodsName())
            .append("goodsType", getGoodsType())
            .append("goodsDesc", getGoodsDesc())
            .append("catId", getCatId())
            .append("catId1", getCatId1())
            .append("catId2", getCatId2())
            .append("catId3", getCatId3())
            .append("catId4", getCatId4())
            .append("catName", getCatName())
            .append("catName1", getCatName1())
            .append("catName2", getCatName2())
            .append("catName3", getCatName3())
            .append("catName4", getCatName4())
            .append("tinyName", getTinyName())
            .append("countryId", getCountryId())
            .append("warehouse", getWarehouse())
            .append("customs", getCustoms())
            .append("isCustoms", getIsCustoms())
            .append("marketPrice", getMarketPrice())
            .append("isPreSale", getIsPreSale())
            .append("preSaleTime", getPreSaleTime())
            .append("shipmentLimitSecond", getShipmentLimitSecond())
            .append("costTemplateId", getCostTemplateId())
            .append("customerNum", getCustomerNum())
            .append("buyLimit", getBuyLimit())
            .append("orderLimit", getOrderLimit())
            .append("isRefundable", getIsRefundable())
            .append("secondHand", getSecondHand())
            .append("isFolt", getIsFolt())
            .append("warmTips", getWarmTips())
            .append("outGoodsId", getOutGoodsId())
            .append("imageUrl", getImageUrl())
            .append("carouselGallery", getCarouselGallery())
            .append("detailGallery", getDetailGallery())
            .append("invoiceStatus", getInvoiceStatus())
            .append("quanGuoLianBao", getQuanGuoLianBao())
            .append("zhiHuanBuXiu", getZhiHuanBuXiu())
            .append("songHuoRuHu", getSongHuoRuHu())
            .append("shangMenAnZhuang", getShangMenAnZhuang())
            .append("songHuoAnZhuang", getSongHuoAnZhuang())
            .append("maiJiaZiTi", getMaiJiaZiTi())
            .append("badFruitClaim", getBadFruitClaim())
            .append("lackOfWeightClaim", getLackOfWeightClaim())
            .append("originCountryId", getOriginCountryId())
            .append("skuListOriginId", getSkuListOriginId())
            .append("goodsPropertiesOriginId", getGoodsPropertiesOriginId())
            .append("overseaGoodsOriginId", getOverseaGoodsOriginId())
            .append("carouselVideoOriginId", getCarouselVideoOriginId())
            .append("carouselVideoOrigin", getCarouselVideoOrigin())
            .append("mallService", getMallService())
            .append("shipmentLimitServer", getShipmentLimitServer())
            .append("costTemplateServer", getCostTemplateServer())
            .append("refundableServer", getRefundableServer())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .toString();
    }
}
