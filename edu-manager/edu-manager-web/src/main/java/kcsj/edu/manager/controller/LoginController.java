package kcsj.edu.manager.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kcsj.edu.common.pojo.HttpResult;

@Controller
public class LoginController {
	
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
	
	@GetMapping("/logout")
	public String logout() {
		//shiro退出登录
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
}
