package kcsj.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kcsj.edu.common.pojo.EasyUIDataGridResult;
import kcsj.edu.manager.system.service.PermissionService;

@Controller
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("page/permission/{page}")
	public String prems(@PathVariable String page) {
		return "permission/"+page;
	}
	
	@GetMapping("/perms/list")
	@ResponseBody
	public EasyUIDataGridResult getPermsList(int page, int rows) {
		EasyUIDataGridResult result = permissionService.listPerms(page, rows);
		return result;
	}
}
