package com.douglasmonteles.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasmonteles.workshopmongo.domain.Post;
import com.douglasmonteles.workshopmongo.repositories.PostRepository;
import com.douglasmonteles.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		var post = postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado! Id: " + id));
		
		return post;
	}
	
}
