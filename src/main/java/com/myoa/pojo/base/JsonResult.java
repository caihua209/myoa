package com.myoa.pojo.base;

import java.io.Serializable;

/**
 * json返回对象
 * @author caish
 * @date 2018年7月26日
 */
public class JsonResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 是否成功 */
	private boolean success = false;
	/** 返回消息 */
	private String message = "";
	/** 数据 */
	private T data = null;

	public JsonResult() {
	}

	public JsonResult(boolean success) {
		this.success = success;
	}

	public JsonResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public JsonResult(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
