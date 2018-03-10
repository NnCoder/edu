package test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitTest {
	
	@Test
	public void test() {
		ApplicationContext atx1 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		ApplicationContext atx2 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
	}
}
