package com.myoa.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myoa.pojo.base.JsonResult;
import com.myoa.pojo.system.SysUser;


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
	@ResponseBody
	public JsonResult<String> login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		JsonResult<String> result = new JsonResult<>();
		if ("admin".equals(username) && "123".equals(password)) {
			SysUser user = new SysUser();
			user.setUserName(username);
			user.setPassword(password);
			this.getRequest().getSession().setAttribute("user", user);
			result.setSuccess(true);
			result.setMessage("登录成功");
		} else {
			result.setSuccess(false);
			result.setMessage("登录失败");
		}
		return result;
	}
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = this.getModelAndView();
		// TODO 确认是否登录
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if (user == null) {
			mv.setViewName("login_soft");
			return mv;
		}
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
	
}
