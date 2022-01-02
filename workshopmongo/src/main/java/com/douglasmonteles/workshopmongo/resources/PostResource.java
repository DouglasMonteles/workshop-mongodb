package com.douglasmonteles.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douglasmonteles.workshopmongo.domain.Post;
import com.douglasmonteles.workshopmongo.resources.utils.URL;
import com.douglasmonteles.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		var post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(
				@RequestParam(value = "text", defaultValue = "") String text
			) {
		var textDecoded = URL.decodeParam(text); 
		var posts = postService.findByTitle(textDecoded);
		
		return ResponseEntity.ok().body(posts);
	}
	
}
