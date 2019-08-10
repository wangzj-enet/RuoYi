package com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 原商品属性表 pdd_goods_properties_origin
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class PddGoodsPropertiesOrigin extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long goodsPropertiesOriginId;
	/** 源数据表id */
	private Long goodsDataOriginId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 三方id */
	private Long thirdId;
	/** 父属性id */
	private Long parentSpecId;
	/** 属性id */
	private Long specId;
	/** 销售属性备注 */
	private String note;
	/** 图片url */
	private String imgUrl;
	/** 销售属性组id */
	private Long groupId;
	/** 模板属性`id` */
	private Long templatePid;
	/** 属性值`id` */
	private Long vid;
	/** 属性值 */
	private String value;
	/** 属性单位 */
	private String valueUnit;

	public void setGoodsPropertiesOriginId(Long goodsPropertiesOriginId) 
	{
		this.goodsPropertiesOriginId = goodsPropertiesOriginId;
	}

	public Long getGoodsPropertiesOriginId() 
	{
		return goodsPropertiesOriginId;
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
	public void setParentSpecId(Long parentSpecId) 
	{
		this.parentSpecId = parentSpecId;
	}

	public Long getParentSpecId() 
	{
		return parentSpecId;
	}
	public void setSpecId(Long specId) 
	{
		this.specId = specId;
	}

	public Long getSpecId() 
	{
		return specId;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}
	public void setImgUrl(String imgUrl) 
	{
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() 
	{
		return imgUrl;
	}
	public void setGroupId(Long groupId) 
	{
		this.groupId = groupId;
	}

	public Long getGroupId() 
	{
		return groupId;
	}
	public void setTemplatePid(Long templatePid) 
	{
		this.templatePid = templatePid;
	}

	public Long getTemplatePid() 
	{
		return templatePid;
	}
	public void setVid(Long vid) 
	{
		this.vid = vid;
	}

	public Long getVid() 
	{
		return vid;
	}
	public void setValue(String value) 
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	public void setValueUnit(String valueUnit) 
	{
		this.valueUnit = valueUnit;
	}

	public String getValueUnit() 
	{
		return valueUnit;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsPropertiesOriginId", getGoodsPropertiesOriginId())
            .append("goodsDataOriginId", getGoodsDataOriginId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("thirdId", getThirdId())
            .append("parentSpecId", getParentSpecId())
            .append("specId", getSpecId())
            .append("note", getNote())
            .append("imgUrl", getImgUrl())
            .append("groupId", getGroupId())
            .append("templatePid", getTemplatePid())
            .append("vid", getVid())
            .append("value", getValue())
            .append("valueUnit", getValueUnit())
            .append("remark", getRemark())
            .toString();
    }
}
