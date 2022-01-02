package com.douglasmonteles.workshopmongo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		var diaEmMilisegundos = 24 * 60 * 60 * 1000;
		maxDate = new Date(maxDate.getTime() + diaEmMilisegundos);
		
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
