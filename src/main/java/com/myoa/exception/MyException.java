package com.myoa.exception;

/**
 * 自定义异常
 * @author caish
 * @date 2018年8月10日
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = -6701679363791754125L;

	private String code;
	private String msg;

	public MyException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
