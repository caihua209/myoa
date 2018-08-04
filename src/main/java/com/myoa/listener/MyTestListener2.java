package com.myoa.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.myoa.event.MyTestEvent;
import com.myoa.pojo.system.SysUser;

/**
 * 测试监听器
 * <pre>
 *  1.非注解方式,需要实现ApplicationListener<事件类>
 *  2.注解方式,在方法上加@EventListener注解,不需实现ApplicationListener<>
 * </pre>
 * 发布器为:TestEventPubLisher
 * @author caish
 * @date 2018年8月2日
 */
@Component
public class MyTestListener2 {

	/**
	 * 监听方法一
	 * @param event
	 */
	@EventListener
	public void testListener1(MyTestEvent event) {
		SysUser user = (SysUser) event.getSource();
		System.out.println(user.getName() + "注解式监听器:" + event.getMsg());
	}

	/**
	 * 监听方法二
	 * 添加@Async注解,把方法变成异步处理.可以在监听到事件后,不影响主线程.
	 * 但是此注解不能标注static修饰的方法
	 * 注解的应用范围： 
	 * 类：表示这个类中的所有方法都是异步的 
	 * 方法：表示这个方法是异步的，如果类也注解了，则以这个方法的注解为准 
	 * @param event
	 */
	@EventListener
	@Async
	public void testListener2(MyTestEvent event) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("异步注解式监听器:" + event.getMsg());
	}

}
