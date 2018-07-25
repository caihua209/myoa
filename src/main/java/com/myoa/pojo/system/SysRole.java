package com.myoa.pojo.system;

import com.myoa.pojo.base.BaseEntity;

/**
 * 角色实体
 * @author caish
 * @date 2018年7月4日
 */
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = -3743579730336909711L;

	/** 系统角色ID */
	private String roleId;

	/** 系统角色名称 */
	private String roleName;

	/** 状态 0:不删除 1:删除 */
	private Integer status;

	/** 备注 */
	private String remark;

	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
