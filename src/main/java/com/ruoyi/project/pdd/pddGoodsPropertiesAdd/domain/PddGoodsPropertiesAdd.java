package com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品属性表 pdd_goods_properties_add
 * 
 * @author ruoyi
 * @date 2019-08-11
 */
public class PddGoodsPropertiesAdd extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long goodsPropertiesAddId;
	/** 源数据表id */
	private Long goodsDataAddId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 三方id */
	private Long thirdId;
	/** 父属性id，非销售属性不用传 */
	private Long parentSpecId;
	/** 属性id，非销售属性不用传 */
	private Long specId;
	/** 销售属性备注 */
	private String note;
	/** 销售属性图片url */
	private String imgUrl;
	/** 本地图片url */
	private String localImgUrl;
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
	/** 状态（0正常 1暂停） */
	private String status;

	public void setGoodsPropertiesAddId(Long goodsPropertiesAddId) 
	{
		this.goodsPropertiesAddId = goodsPropertiesAddId;
	}

	public Long getGoodsPropertiesAddId() 
	{
		return goodsPropertiesAddId;
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
	public void setLocalImgUrl(String localImgUrl) 
	{
		this.localImgUrl = localImgUrl;
	}

	public String getLocalImgUrl() 
	{
		return localImgUrl;
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
            .append("goodsPropertiesAddId", getGoodsPropertiesAddId())
            .append("goodsDataAddId", getGoodsDataAddId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("thirdId", getThirdId())
            .append("parentSpecId", getParentSpecId())
            .append("specId", getSpecId())
            .append("note", getNote())
            .append("imgUrl", getImgUrl())
            .append("localImgUrl", getLocalImgUrl())
            .append("groupId", getGroupId())
            .append("templatePid", getTemplatePid())
            .append("vid", getVid())
            .append("value", getValue())
            .append("valueUnit", getValueUnit())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
