package com.ruoyi.project.pdd.pddGoodsDataOrigin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 原商品数据解析表 pdd_goods_data_origin
 * 
 * @author ruoyi
 * @date 2019-08-02
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
	/** 状态 */
	private String status;

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
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
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
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
