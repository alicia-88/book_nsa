package com.nsa.book_nsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author) {
		Author savedAuthor = authorService.createAuthor(author);
		return ResponseEntity.ok(savedAuthor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateAuthor(@PathVariable("id") int id ,  @Valid @RequestBody Author author) {
		Author updateAuthor = authorService.getAuthorById(id);
		if (updateAuthor != null) {
			authorService.updateAuthor(author.getId(), author);
			return ResponseEntity.ok(author);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

	@GetMapping
	public ResponseEntity<?> getAllAuthors() {
		List<Author> authors = authorService.getAllAuthors();
		return ResponseEntity.ok(authors);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAuthorById(@PathVariable int id) {
		Author author = authorService.getAuthorById(id);
		return (author != null) ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
		Author author = authorService.getAuthorById(id);
		if (author != null) {
			authorService.deleteAuthor(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
