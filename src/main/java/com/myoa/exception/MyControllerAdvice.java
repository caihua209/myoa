package com.myoa.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 * @author caish
 * @date 2018年8月10日
 */
@ControllerAdvice
public class MyControllerAdvice {

	/**
	 * 全局异常捕捉处理
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> errorHandler(Exception ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 100);
		map.put("msg", ex.getMessage());
		return map;
	}

	/**
	 * 拦截捕捉自定义异常 MyException.class
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = MyException.class)
	public Map<String, Object> myErrorHandler(MyException ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		return map;
	}
}
