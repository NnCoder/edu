package kcsj.edu.manager.system.service;

import java.util.Set;

public interface PermissionService {
	Set<String> getPerms(int userId);
}
