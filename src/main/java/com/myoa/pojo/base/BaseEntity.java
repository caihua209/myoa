package com.myoa.pojo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * @author caish
 * @date 2018年7月4日
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 创建时间 */
	protected Date createTime;
	/** 更新时间 */
	protected Date updateTime;
	/** 创建人 */
	protected String createBy;
	/** 更新人 */
	protected String updateBy;

	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
