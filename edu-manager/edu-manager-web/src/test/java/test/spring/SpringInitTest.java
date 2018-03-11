package test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kcsj.edu.manager.mapper.UserMapper;

public class SpringInitTest {
	
	@Test
	public void test() {
		ApplicationContext atx1 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
	}
}
