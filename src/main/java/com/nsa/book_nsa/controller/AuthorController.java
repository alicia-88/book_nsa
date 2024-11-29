package com.nsa.book_nsa.controller;

import java.util.List;

import com.nsa.book_nsa.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsa.book_nsa.model.Author;
import com.nsa.book_nsa.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;


	@PostMapping(consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author) {
		Author savedAuthor = authorService.createAuthor(author);
		return ResponseEntity.ok(savedAuthor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateAuthor(@PathVariable("id") Long id ,  @Valid @RequestBody Author author) {
		
		Author updateAuthor = authorService.updateAuthor(id, author);
		return ResponseEntity.ok(updateAuthor);
		
	}

	@GetMapping
	public ResponseEntity<?> getAllAuthors() {
		List<Author> authors = authorService.getAllAuthors();
		return ResponseEntity.ok(authors);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
		Author author = authorService.getAuthorById(id);
		return ResponseEntity.ok(author);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.noContent().build();
	}
}
