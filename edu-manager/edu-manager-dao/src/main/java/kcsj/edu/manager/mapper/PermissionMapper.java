package kcsj.edu.manager.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import kcsj.edu.manager.pojo.Permission;

public interface PermissionMapper extends BaseMapper<Permission>{
	public Set<String> selectPermsByUserId(@Param("userId")Integer userId);
	public List<Permission> selectMenuByUserId(@Param("userId")Integer userId, @Param("parentId")int parentId);
}
