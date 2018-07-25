package com.myoa.util;

import java.util.UUID;
/**
 * UUID工具类
 * @author caish
 * @date 2018年7月8日
 */
public class UuidUtil {

	/**
	 * 获取32位UUID
	 * @return
	 */
	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}

