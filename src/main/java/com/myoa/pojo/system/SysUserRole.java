package com.myoa.pojo.system;

import com.myoa.pojo.base.BaseEntity;

/**
 * 用戶角色实体
 * @author caihua
 * @date 2018年7月4日
 */
public class SysUserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;
	private String roleId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
