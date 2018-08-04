package com.myoa.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.myoa.event.MyTestEvent;
import com.myoa.pojo.system.SysUser;

/**
 * 测试监听器
 * <pre>
 *  1.非注解方式,需要实现ApplicationListener<事件类>
 *  2.注解方式,在方法上加@EventListener注解,不需实现ApplicationListener<>
 * </pre>
 * 发布器:TestEventPubLisher
 * @author caish
 * @date 2018年8月2日 
 */
@Component
public class MyTestListener implements ApplicationListener<MyTestEvent> {

	@Override
	public void onApplicationEvent(MyTestEvent event) {
		SysUser user = (SysUser) event.getSource();
		System.out.println(user.getName() + "非注解式监听器:" + event.getMsg());
	}

}
