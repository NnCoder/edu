package kcsj.edu.protal.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("time", new Date());
		return "tch/index";
	}
}
