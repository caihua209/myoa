package com.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myoa.event.MyTestEvent;
import com.myoa.pojo.system.SysUser;

/**
 * 测试事件发布器
 * @author caish
 * @date 2018年8月2日 
 */
public class TestEventPubLisher {

	private ApplicationContext applicationContext;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring-all.xml");
	}

	/**
	 * 测试查询
	 * @throws InterruptedException 
	 */
    @Test
    public void test1() throws InterruptedException {
    	SysUser user = new SysUser();
    	user.setName("菜花");
    	applicationContext.publishEvent(new MyTestEvent(user, "我来了!"));
    	Thread.sleep(3 * 1000);// 不让主进程过早结束
    }
}
