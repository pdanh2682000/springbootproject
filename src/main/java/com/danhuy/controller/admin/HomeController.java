package com.danhuy.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeControllerOfAdmin")
public class HomeController {
	
	@RequestMapping("/admin")
	public ModelAndView home() {
		
		return new ModelAndView("admin/home");
	}
}
