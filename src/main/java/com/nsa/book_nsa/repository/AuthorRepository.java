package com.nsa.book_nsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsa.book_nsa.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // Méthodes personnalisées (si nécessaires)

    // Trouver un auteur par son nom de famille
    Author findByLastName(String lastName);

    // Trouver tous les auteurs d'une certaine nationalité
    List<Author> findByNationality(String nationality);
}
