package com.spring.codeblog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

@RestController
@RequestMapping("/api")
public class MainAPI {
	
	@Autowired
	CodeblogService codeblogService;
	
	@GetMapping("/")
	public List<Post> getAllPosts(){
		List<Post> posts = codeblogService.findAll("DESC");
		
		return posts;
	}
	
	@GetMapping("/post/{id}")
	public Post getAllPosts(@PathVariable long id){
		Post posts = codeblogService.findById(id);
		
		return posts;
	}

}
