package kcsj.edu.manager.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kcsj.edu.manager.pojo.User;

@Controller
public class IndexController {
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("time", new Date());
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("name",user.getName());
		return "index";
	}
	
}
