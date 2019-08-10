package com.ruoyi.project.pdd.pddGoodsDownload.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 原商品数据下载表 pdd_goods_download
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class PddGoodsDownload extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long downloadId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 商品名称 */
	private String goodsName;
	/** json数据 */
	private String goodsJson;
	/** 数据md5 */
	private String jsonMd5;
	/** 状态 */
	private String status;

	public void setDownloadId(Long downloadId) 
	{
		this.downloadId = downloadId;
	}

	public Long getDownloadId() 
	{
		return downloadId;
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
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsJson(String goodsJson) 
	{
		this.goodsJson = goodsJson;
	}

	public String getGoodsJson() 
	{
		return goodsJson;
	}
	public void setJsonMd5(String jsonMd5) 
	{
		this.jsonMd5 = jsonMd5;
	}

	public String getJsonMd5() 
	{
		return jsonMd5;
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
            .append("downloadId", getDownloadId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsJson", getGoodsJson())
            .append("jsonMd5", getJsonMd5())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
