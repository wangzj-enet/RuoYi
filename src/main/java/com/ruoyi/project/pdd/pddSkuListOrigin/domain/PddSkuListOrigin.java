package com.ruoyi.project.pdd.pddSkuListOrigin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 原商品sku表 pdd_sku_list_origin
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class PddSkuListOrigin extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long skuListOriginId;
	/** 源数据表id */
	private Long goodsDataOriginId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 三方id */
	private Long thirdId;
	/** 商品规格列表 */
	private String specIdList;
	/** 商品sku外部编码 */
	private String outSkuSn;
	/** sku预览图 */
	private String thumbUrl;
	/** sku送装参数 */
	private Long length;
	/** 重量（g） */
	private Long weight;
	/** 商品sku库存初始数量 */
	private Long quantity;
	/** 商品团购价格 */
	private Long multiPrice;
	/** 商品单买价格 */
	private Long price;
	/** sku购买限制 */
	private Long limitQuantity;
	/** sku上架状态 */
	private String isOnsale;
	/** 状态 */
	private String status;

	public void setSkuListOriginId(Long skuListOriginId) 
	{
		this.skuListOriginId = skuListOriginId;
	}

	public Long getSkuListOriginId() 
	{
		return skuListOriginId;
	}
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
	public void setSpecIdList(String specIdList) 
	{
		this.specIdList = specIdList;
	}

	public String getSpecIdList() 
	{
		return specIdList;
	}
	public void setOutSkuSn(String outSkuSn) 
	{
		this.outSkuSn = outSkuSn;
	}

	public String getOutSkuSn() 
	{
		return outSkuSn;
	}
	public void setThumbUrl(String thumbUrl) 
	{
		this.thumbUrl = thumbUrl;
	}

	public String getThumbUrl() 
	{
		return thumbUrl;
	}
	public void setLength(Long length) 
	{
		this.length = length;
	}

	public Long getLength() 
	{
		return length;
	}
	public void setWeight(Long weight) 
	{
		this.weight = weight;
	}

	public Long getWeight() 
	{
		return weight;
	}
	public void setQuantity(Long quantity) 
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	public void setMultiPrice(Long multiPrice) 
	{
		this.multiPrice = multiPrice;
	}

	public Long getMultiPrice() 
	{
		return multiPrice;
	}
	public void setPrice(Long price) 
	{
		this.price = price;
	}

	public Long getPrice() 
	{
		return price;
	}
	public void setLimitQuantity(Long limitQuantity) 
	{
		this.limitQuantity = limitQuantity;
	}

	public Long getLimitQuantity() 
	{
		return limitQuantity;
	}
	public void setIsOnsale(String isOnsale) 
	{
		this.isOnsale = isOnsale;
	}

	public String getIsOnsale() 
	{
		return isOnsale;
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
            .append("skuListOriginId", getSkuListOriginId())
            .append("goodsDataOriginId", getGoodsDataOriginId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("thirdId", getThirdId())
            .append("specIdList", getSpecIdList())
            .append("outSkuSn", getOutSkuSn())
            .append("thumbUrl", getThumbUrl())
            .append("length", getLength())
            .append("weight", getWeight())
            .append("quantity", getQuantity())
            .append("multiPrice", getMultiPrice())
            .append("price", getPrice())
            .append("limitQuantity", getLimitQuantity())
            .append("isOnsale", getIsOnsale())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
