package com.ruoyi.project.pdd.pddSkuListAdd.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 商品SKU表 pdd_sku_list_add
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public class PddSkuListAdd extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long skuListAddId;
	/** 源数据表id */
	private Long goodsDataAddId;
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
	/** 本地sku预览图 */
	private String localThumbUrl;
	/** sku送装参数 */
	private Long length;
	/** 重量（g） */
	private Long weight;
	/** 商品sku库存初始数量 */
	private Long quantity;
	/** 商品团购价格 */
	private BigDecimal multiPrice;
	/** 商品单买价格 */
	private BigDecimal price;
	/** sku购买限制 */
	private Long limitQuantity;
	/** sku上架状态 */
	private String isOnsale;
	/** 规格 */
	private String specKey;
	/** 规格id */
	private String specKeyId;
	/** 规格值 */
	private String specValue;
	/** 规格值id */
	private String specValueId;
	/** 状态（0正常 1暂停） */
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

	public void setSkuListAddId(Long skuListAddId) 
	{
		this.skuListAddId = skuListAddId;
	}

	public Long getSkuListAddId() 
	{
		return skuListAddId;
	}
	public void setGoodsDataAddId(Long goodsDataAddId) 
	{
		this.goodsDataAddId = goodsDataAddId;
	}

	public Long getGoodsDataAddId() 
	{
		return goodsDataAddId;
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
	public void setLocalThumbUrl(String localThumbUrl) 
	{
		this.localThumbUrl = localThumbUrl;
	}

	public String getLocalThumbUrl() 
	{
		return localThumbUrl;
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
	public void setMultiPrice(BigDecimal multiPrice) 
	{
		this.multiPrice = multiPrice;
	}

	public BigDecimal getMultiPrice() 
	{
		return multiPrice;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public BigDecimal getPrice() 
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
	public void setSpecKey(String specKey) 
	{
		this.specKey = specKey;
	}

	public String getSpecKey() 
	{
		return specKey;
	}
	public void setSpecKeyId(String specKeyId) 
	{
		this.specKeyId = specKeyId;
	}

	public String getSpecKeyId() 
	{
		return specKeyId;
	}
	public void setSpecValue(String specValue) 
	{
		this.specValue = specValue;
	}

	public String getSpecValue() 
	{
		return specValue;
	}
	public void setSpecValueId(String specValueId) 
	{
		this.specValueId = specValueId;
	}

	public String getSpecValueId() 
	{
		return specValueId;
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
            .append("skuListAddId", getSkuListAddId())
            .append("goodsDataAddId", getGoodsDataAddId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("thirdId", getThirdId())
            .append("specIdList", getSpecIdList())
            .append("outSkuSn", getOutSkuSn())
            .append("thumbUrl", getThumbUrl())
            .append("localThumbUrl", getLocalThumbUrl())
            .append("length", getLength())
            .append("weight", getWeight())
            .append("quantity", getQuantity())
            .append("multiPrice", getMultiPrice())
            .append("price", getPrice())
            .append("limitQuantity", getLimitQuantity())
            .append("isOnsale", getIsOnsale())
            .append("specKey", getSpecKey())
            .append("specKeyId", getSpecKeyId())
            .append("specValue", getSpecValue())
            .append("specValueId", getSpecValueId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .toString();
    }
}
