package test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kcsj.edu.manager.mapper.UserMapper;

public class SpringInitTest {
	
	@Test
	public void test() {
		ApplicationContext atx1 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		ApplicationContext atx2 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
		UserMapper userMapper = atx1.getBean(UserMapper.class);
		
	}
}
