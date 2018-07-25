package com.myoa.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录控制器
 * @author caihua
 * @date 2018年7月8日
 */
@Controller
public class LoginController extends BaseController {

	/**
	 * 跳转登录页面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = this.getModelAndView();
		//mv.setViewName("login");
		mv.setViewName("login_soft");
		return mv;
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		ModelAndView mv = this.getModelAndView();
		if ("admin".equals(username) && "123".equals(password)) {
			mv.setViewName("index");
		} else {
			mv.setViewName("login_soft");
			mv.addObject("msg", "用户或者密码错误!");
		}
		return mv;
	}
	
}
