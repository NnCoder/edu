package kcsj.edu.manager.system.service;

import com.baomidou.mybatisplus.service.IService;

import kcsj.edu.manager.pojo.User;

public interface UserService extends IService<User>{
	
	User getUserByName(String username);
}
