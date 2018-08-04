package com.myoa.event;

import org.springframework.context.ApplicationEvent;

/**
 * 测试事件
 * @author caish
 * @date 2018年8月2日 
 */
public class MyTestEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public MyTestEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
