package test.spring;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kcsj.edu.manager.mapper.PermissionMapper;
import kcsj.edu.manager.mapper.UserMapper;
import kcsj.edu.manager.pojo.Permission;
import kcsj.edu.manager.pojo.User;
import kcsj.edu.manager.system.service.UserService;

public class SpringInitTest {
	
	@Test
	public void test() {
		ApplicationContext atx1 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		/*PermissionMapper permissionMapper = atx1.getBean(PermissionMapper.class);
		List<Permission> list = permissionMapper.selectMenuByUserId(1, 0);
		for (Permission permission : list) {
			System.out.println(permission.getName());
		}*/
		UserService userService = atx1.getBean(UserService.class);
		User user = userService.getUserByName("mrche");
		System.out.println(user);
	}
}
