package com.spring.codeblog.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.CodeblogService;

@Service
public class CodeblogServiceImpl implements CodeblogService {
	
	@Autowired
	CodeblogRepository codeblogRepository;

	@Override
	public List<Post> findAll(String order) {
		List orderby = null;
		if(order.equals("DESC")) {
			orderby = codeblogRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		}else if(order.equals("ASC")) {
			orderby = codeblogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		}
		
		return orderby;
	}

	@Override
	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}
	
}
