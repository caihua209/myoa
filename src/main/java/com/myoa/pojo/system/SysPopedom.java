package com.myoa.pojo.system;

import com.myoa.pojo.base.BaseEntity;

/**
 * 权限实体类(对应角色和模快的中间表)
 * @author caihua
 * @date 2018年7月4日
 */
public class SysPopedom extends BaseEntity {

	private static final long serialVersionUID = -6684734809890217522L;

	/** 主键ID */
	private String id;
	/** 角色ID */
	private String roleId;
	/** 模块ID */
	private String moduleId;
	//TODO 如何处理(区分)菜单和具体功能操作,以及处理具有权限的菜单下的功能
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	
	
}
