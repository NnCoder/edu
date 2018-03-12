package kcsj.edu.manager.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kcsj.edu.common.pojo.HttpResult;
import kcsj.edu.manager.system.service.PermissionService;

@Controller
public class LoginController {
	
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("/login")
	public String login() {return "page-login";};
	
	@PostMapping("/login")
	@ResponseBody
	public HttpResult ajaxLogin(String username, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (Exception e) {
			return HttpResult.error(e.getMessage());
		}
		return HttpResult.ok();
	}
}
