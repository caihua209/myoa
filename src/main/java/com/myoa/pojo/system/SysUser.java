package com.myoa.pojo.system;

import com.myoa.pojo.base.BaseEntity;

/**
 * 用户实体
 * @author caish
 * @date 2018年7月4日
 */
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 3316775622183217239L;

	/** 系统用户ID */
	private String userId;

	/** 系统用户登录名 */
	private String userName;

	/** 系统用户密码 */
	private String password;

	/** 系统用户真名 */
	private String name;

	/** 系统用户手机号 */
	private String phone;

	/** 系统用户邮箱 */
	private String email;

	/** IP地址 */
	private String ip;

	/** 最后登录时间 */
	private String lastLogin;

	/** 系统用户状态(0.停用 1.启用) */
	private Integer status;

	/** 系统用户类型 */
	private String typeId;

	/** 备注 */
	private String remark;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
