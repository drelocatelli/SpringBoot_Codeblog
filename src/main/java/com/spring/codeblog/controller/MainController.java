package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.service.CodeblogService;

import com.spring.codeblog.model.Post;

@Controller
public class MainController {
	
	public static String title = "Code Blog";
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
		List<Post> posts = codeblogService.findAll("DESC");
		model.addObject("posts", posts);
		model.addObject("title", title);
		return model;
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		model.setViewName("post");
		Post post = codeblogService.findById(id);
		model.addObject("post", post);
		model.addObject("title", title);
		return model;
	}
	
	// new post
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public ModelAndView getPostForm() {
		model.setViewName("postForm");
		model.addObject("title", title);
		return model;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigat??rios foram preenchidos!");
			return "redirect:/newpost";
		}else {
			post.setData(LocalDate.now());
			codeblogService.save(post);
			return "redirect:/posts";
		}
	}
	
}
