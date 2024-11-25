package com.nsa.book_nsa.service;

import java.util.List;
import java.util.Optional;

import com.nsa.book_nsa.exception.DuplicateException;
import com.nsa.book_nsa.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsa.book_nsa.model.Author;
import com.nsa.book_nsa.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	// Récupérer tous les auteurs
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	// Récupérer un auteur par ID
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("message", id));
	}

	// Créer un nouvel auteur
	public Author createAuthor(Author author) {
		// Avant de créer, tu peux vérifier si l'auteur existe déjà ou non
		Boolean isAuthor = authorRepository.existsByFirstNameAndLastNameAndBirthDate(author.getFirstName(),
				author.getLastName(), author.getBirthDate());
		if (isAuthor) {
			throw new DuplicateException("author", author.getId());
		}
		return authorRepository.save(author); // Création du nouvel auteur
	}

	// Mettre à jour un auteur existant
	public Author updateAuthor(Long id, Author authorDetails) {
		// Vérifier si l'auteur existe avant de mettre à jour

		Author existingAuthor = getAuthorById(id);

		// Mettre à jour les champs nécessaires
		existingAuthor.setLastName(authorDetails.getLastName());
		existingAuthor.setFirstName(authorDetails.getFirstName());
		existingAuthor.setBirthDate(authorDetails.getBirthDate());
		existingAuthor.setNationality(authorDetails.getNationality());

		return authorRepository.save(existingAuthor); // Sauvegarder l'auteur mis à jour

	}

	// Supprimer un auteur par ID
	public void deleteAuthor(Long id) {
		getAuthorById(id);
		authorRepository.deleteById(id);
	}
}
