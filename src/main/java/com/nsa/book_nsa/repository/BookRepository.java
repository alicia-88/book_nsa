package com.nsa.book_nsa.repository;

import com.nsa.book_nsa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByTitleContainingIgnoreCase(String title);
}
