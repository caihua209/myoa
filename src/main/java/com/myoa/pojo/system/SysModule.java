package com.myoa.pojo.system;

import com.myoa.pojo.base.BaseEntity;

/**
 * 系统模块实体(菜单)
 * @author caish
 * @date 2018年7月4日 
 */
public class SysModule extends BaseEntity {

	private static final long serialVersionUID = 7199419801018820306L;

	/** 系统模块ID */
	private String moduleId;

	/** 系统模块编号 */
	private String code;
	
	/** 系统模块名称 */
	private String name;

	/** 系统模块父级ID */
	private String parentId;

	/** 系统模块URL */
	private String url;

	/** 系统模块类型(0:子系统,1:菜单,2:功能,3:按钮) */
	private String type;
	
	/** 系统模块图标 */
	private String icon;

	/** 系统模块状态 0:无效 1:有效 */
	private Integer status;

	/** 排序 */
	private String sort;	
	
	/** 备注 */
	private String remark;

	
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
