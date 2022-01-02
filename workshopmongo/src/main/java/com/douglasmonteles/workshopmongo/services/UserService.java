package com.douglasmonteles.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasmonteles.workshopmongo.domain.User;
import com.douglasmonteles.workshopmongo.dtos.UserDTO;
import com.douglasmonteles.workshopmongo.repositories.UserRepository;
import com.douglasmonteles.workshopmongo.services.exceptions.ObjectNotFoundException;

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
	
	public UserDTO findById(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
		
		return new UserDTO(user);
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		this.findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromUserDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
}
