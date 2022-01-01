package com.douglasmonteles.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglasmonteles.workshopmongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		var maria = new User("1", "Maria", "maria@gmail.com");
		var alex = new User("2", "Alex", "alex@gmail.com");
		
		var users = new ArrayList<User>();
		users.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(users); 
	}
	
}
