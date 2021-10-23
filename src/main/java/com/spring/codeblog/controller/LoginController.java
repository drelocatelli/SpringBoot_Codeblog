package com.spring.codeblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static ModelAndView model = new ModelAndView();

	@GetMapping("/login")
	public ModelAndView login() {
		model.setViewName("login");
		model.addObject("title", MainController.title);
		return model;
	}
	
}
