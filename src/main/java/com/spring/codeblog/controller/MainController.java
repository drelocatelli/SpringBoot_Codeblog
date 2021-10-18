package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.service.CodeblogService;

import com.spring.codeblog.model.Post;

@Controller
public class MainController {
	
	private static String title = "Code Blog";
	
	@Autowired
	CodeblogService codeblogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView model = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		model.addObject("posts", posts);
		model.addObject("title", title);
		return model;
	}

}
