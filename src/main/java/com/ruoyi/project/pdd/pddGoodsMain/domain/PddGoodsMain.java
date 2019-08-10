package com.ruoyi.project.pdd.pddGoodsMain.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 主记录表 pdd_goods_main
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class PddGoodsMain extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 商品名称 */
	private String goodsName;
	/** json数据 */
	private String jsonData;
	/** 状态 */
	private String status;
	/** 源头 */
	private String source;

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
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setJsonData(String jsonData) 
	{
		this.jsonData = jsonData;
	}

	public String getJsonData() 
	{
		return jsonData;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getSource() 
	{
		return source;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("jsonData", getJsonData())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("source", getSource())
            .toString();
    }
}
