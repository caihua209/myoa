package com.myoa.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		mv.setViewName("login_soft");
		return mv;
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		ModelAndView mv = this.getModelAndView();
		try {
			Subject subject = SecurityUtils.getSubject(); 
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			mv.setViewName("redirect:index.do");
		} catch (AuthenticationException e) {
			mv.addObject("error", true);
			mv.setViewName("login_soft");
		}
		return mv;
	}
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("index/index");
		return mv;
	}
	
	/**
	 * 加载首页内容
	 * @return
	 */
	@RequestMapping(value = "/loadIndexContent")
	@ResponseBody
	public ModelAndView loadIndexContent() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("index/index-content");
		return mv;
	}
	
	/**
	 * 加载首页内容
	 * @return
	 */
	@RequestMapping(value = "/test")
	@ResponseBody
	public ModelAndView test() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("index/test");
		return mv;
	}
	
}
