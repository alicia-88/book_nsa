package com.nsa.book_nsa.repository;

import com.nsa.book_nsa.model.Book;
import com.nsa.book_nsa.model.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   Category findByName(String name);
}

