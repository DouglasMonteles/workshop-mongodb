package com.douglasmonteles.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasmonteles.workshopmongo.dtos.UserDTO;
import com.douglasmonteles.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll() {
		return userRepository.findAll()
				.stream()
				.map(user -> new UserDTO(user))
				.collect(Collectors.toList());
	}
	
}
