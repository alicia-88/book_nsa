package com.nsa.book_nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.User;
import com.nsa.book_nsa.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user", id));
	}

	public User addUser(User userDetails) {
		return userRepository.save(userDetails);
	}

	public void deleteUserById(Long id) {
		User user = getUserById(id);
		userRepository.deleteById(user.getId());
	}
	
	public User updateUser(Long id , User userDetails) {
		//Je verifie que l'user existe 
		User user = getUserById(id);
		// Je lui permets de modifier son password
		user.setPassword(userDetails.getPassword());
		return userRepository.save(user);
		
	}

}
