package com.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author caish
 * @date 2018年8月7日
 */
public class TestDemo {

	// @Autowired
	MockHttpServletRequest request;
	//
	// @Autowired
	// MockHttpSession session;
	//
	// @Autowired
	// MockHttpServletResponse response;
	private ApplicationContext applicationContext;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring-all.xml");
	}

	@Test
	public void test1() {
		request = new MockHttpServletRequest();
		// ServletContext servletContext =
		// request.getSession().getServletContext();
		System.out.println(request);
		ServletContext servletContext = request.getSession().getServletContext();
		System.out.println(servletContext);
		String realPath = servletContext.getRealPath("/");
		System.out.println(realPath);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("catalina.home"));
	}
}
