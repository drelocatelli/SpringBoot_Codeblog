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
	private static ModelAndView model = new ModelAndView();
	
	@Autowired
	CodeblogService codeblogService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		model.setViewName("index");
		model.addObject("title", title);
		return model;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		model.setViewName("posts");
		List<Post> posts = codeblogService.findAll();
		model.addObject("posts", posts);
		model.addObject("title", title);
		return model;
	}

}
