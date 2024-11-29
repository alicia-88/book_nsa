package com.nsa.book_nsa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsa.book_nsa.model.User;
import com.nsa.book_nsa.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// Ecriture de mes Endpoints
	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody User userDetails){
		User user = userService.addUser(userDetails);
		return ResponseEntity.status(201).body(user);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id , @Valid @RequestBody User userDetails){
		User user = userService.updateUser(id, userDetails);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id ){
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}

}
