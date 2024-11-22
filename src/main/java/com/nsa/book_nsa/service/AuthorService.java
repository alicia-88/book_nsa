package com.nsa.book_nsa.service;

import java.util.List;
import java.util.Optional;

import com.nsa.book_nsa.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
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
        return authorRepository.findById(id).orElse(null);
    }

 // Créer un nouvel auteur
    public Author createAuthor(Author author) {
        // Avant de créer, tu peux vérifier si l'auteur existe déjà ou non
       Boolean isAuthor = authorRepository.existsByFirstNameAndLastNameAndBirthDate(author.getFirstName(), author.getLastName(), author.getBirthDate());
    	if(isAuthor) {
            throw new DuplicateException("author", author.getId());
        }
        return authorRepository.save(author); // Création du nouvel auteur
    }
    
 // Mettre à jour un auteur existant
    public Author updateAuthor(Long id, Author authorDetails) {
        // Vérifier si l'auteur existe avant de mettre à jour

        Optional<Author> existingAuthor = authorRepository.findById(id);
        
        if (existingAuthor.isPresent()) {
            // L'auteur existe, donc on met à jour ses informations
            Author author = existingAuthor.get();
            
            // Mettre à jour les champs nécessaires
            author.setLastName(authorDetails.getLastName());
            author.setFirstName(authorDetails.getFirstName());
            author.setBirthDate(authorDetails.getBirthDate());
            author.setNationality(authorDetails.getNationality());

            return authorRepository.save(author); // Sauvegarder l'auteur mis à jour
        } else {
            throw new RuntimeException("Author with id " + id + " not found");
        }
    }

    // Supprimer un auteur par ID
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
