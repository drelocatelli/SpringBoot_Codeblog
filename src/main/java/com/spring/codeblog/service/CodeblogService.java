package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.Post;

public interface CodeblogService {
	
	List<Post> findAll(String order);
	Post findById(long id);
	Post save(Post post);

}
