package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring-mybatis整合测试
* @author caish
* @date 2018年7月3日 
*/
@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatis {

	/**
     * 测试查询
     */
    @Test
    public void test1() {
    	
    }
    
    /**
     * 测试添加
     */
    @Test
    public void test2() {       
    }
}
