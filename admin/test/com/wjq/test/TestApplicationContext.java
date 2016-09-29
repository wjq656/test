package com.wjq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	
	@Test
	public void handler(){
		/*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
		System.out.println("============"+dataSource);*/
		System.out.println(11);

	}
}







