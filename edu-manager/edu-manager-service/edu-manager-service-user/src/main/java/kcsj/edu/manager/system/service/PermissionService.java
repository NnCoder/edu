package kcsj.edu.manager.system.service;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.service.IService;

import kcsj.edu.manager.pojo.Permission;
import kcsj.edu.manager.pojo.vo.MenuVo;

public interface PermissionService extends IService<Permission>{
	Set<String> getPerms(int userId);
	List<MenuVo> getMenuVoByUserId(int userId);
}
