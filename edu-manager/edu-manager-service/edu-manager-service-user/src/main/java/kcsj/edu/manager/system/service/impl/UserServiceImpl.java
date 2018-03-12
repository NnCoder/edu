package kcsj.edu.manager.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import kcsj.edu.manager.mapper.UserMapper;
import kcsj.edu.manager.pojo.User;
import kcsj.edu.manager.system.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByName(String username) {
		EntityWrapper<User> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("username={0}", username);
		List<User> list = userMapper.selectList(entityWrapper);
		return list.isEmpty()?null:list.get(0);
	}
	
}
