package com.myoa.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试spring定时任务(注解式demo)
 * <p>
 * 	spring相关配置:
 * 		<task:executor id="executor" pool-size="5" />  
 * 		<task:scheduler id="scheduler" pool-size="10" />
 * 		<task:annotation-driven executor="executor" scheduler="scheduler" />
 * 	或:
 * 		<task:annotation-driven />
 * </p>
 * @author caish
 * @date 2018年8月9日 
 */
@Component
public class SpringTaskDemo {

	/**
	 * 执行任务
	 * crom配置: {秒} {分} {时} {日} {月} {周} {年(可选)}
	 * 'x/y': x为默认值 y为偏移量
	 */
	@Scheduled(cron="0/3 * * * * ?")
	public void execute() {
		// 每隔三秒打印一次系统时间
		// System.out.println(System.currentTimeMillis());
	}
	
}
