package com.myoa.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myoa.exception.MyException;

/**
 * 测试控制器
 * @author caish
 * @date 2018年8月10日
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/home")
	public String home(ModelMap modelMap) throws Exception {
		// System.out.println(modelMap.get("author").toString());
		// throw new Exception("Sam 错误");
		throw new MyException("101", "Sam错误");

	}
}
