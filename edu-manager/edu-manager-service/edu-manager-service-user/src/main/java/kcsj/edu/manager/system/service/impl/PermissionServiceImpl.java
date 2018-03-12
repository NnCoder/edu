package kcsj.edu.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import kcsj.edu.manager.mapper.PermissionMapper;
import kcsj.edu.manager.pojo.Permission;
import kcsj.edu.manager.pojo.vo.MenuVo;
import kcsj.edu.manager.system.service.PermissionService;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService{
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public Set<String> getPerms(int userId) {
		//获取权限集
		return permissionMapper.selectPermsByUserId(userId);
	}

	@Override
	public List<MenuVo> getMenuVoByUserId(int userId) {
		List<Permission> list = permissionMapper.selectMenuByUserId(userId, 0);
		//最终结果 共2级目录
		List<MenuVo> resultList = new ArrayList<>();
		//父菜单
		MenuVo menuVo = null;
		//子菜单
		MenuVo menuChild = null;
		List<MenuVo> childrens = null;
		//遍历
		for (Permission permission : list) {
			menuVo = new MenuVo();
			menuVo.setId(permission.getId());
			menuVo.setText(permission.getName());
			//menuVo.setUrl(permission.getUrl()); 父菜单没有页面
			//子菜单所有节点
			childrens = new ArrayList<>();
			List<Permission> permissions = permissionMapper.selectMenuByUserId(userId, permission.getParentId());
			for (Permission child : permissions) {
				menuChild = new MenuVo();
				menuChild.setId(child.getId());
				menuChild.setText(child.getName());
				menuChild.setUrl(child.getUrl());
				childrens.add(menuChild);
			}
			menuVo.setChildren(childrens);
			//添加到最终结果集
			resultList.add(menuVo);
		}
		return resultList;
	}
	
}
