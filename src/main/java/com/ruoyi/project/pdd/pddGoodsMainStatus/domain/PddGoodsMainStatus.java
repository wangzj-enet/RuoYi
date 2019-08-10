package com.ruoyi.project.pdd.pddGoodsMainStatus.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 主记录状态表 pdd_goods_main_status
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class PddGoodsMainStatus extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long mainStatusId;
	/** 主记录id */
	private Long mainId;
	/** 商品id */
	private Long goodsId;
	/** 开始时间 */
	private Date startTime;
	/** 总时长/秒 */
	private Long count;
	/** 结束时间 */
	private Date endTime;
	/** 三方id */
	private Long thirdId;
	/** json数据 */
	private String jsonData;
	/** 主表状态 */
	private String mainStatus;
	/** 状态 */
	private String status;

	public void setMainStatusId(Long mainStatusId) 
	{
		this.mainStatusId = mainStatusId;
	}

	public Long getMainStatusId() 
	{
		return mainStatusId;
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
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setCount(Long count) 
	{
		this.count = count;
	}

	public Long getCount() 
	{
		return count;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setThirdId(Long thirdId) 
	{
		this.thirdId = thirdId;
	}

	public Long getThirdId() 
	{
		return thirdId;
	}
	public void setJsonData(String jsonData) 
	{
		this.jsonData = jsonData;
	}

	public String getJsonData() 
	{
		return jsonData;
	}
	public void setMainStatus(String mainStatus) 
	{
		this.mainStatus = mainStatus;
	}

	public String getMainStatus() 
	{
		return mainStatus;
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
            .append("mainStatusId", getMainStatusId())
            .append("mainId", getMainId())
            .append("goodsId", getGoodsId())
            .append("startTime", getStartTime())
            .append("count", getCount())
            .append("endTime", getEndTime())
            .append("thirdId", getThirdId())
            .append("jsonData", getJsonData())
            .append("mainStatus", getMainStatus())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
