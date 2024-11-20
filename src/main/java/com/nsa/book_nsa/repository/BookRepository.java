package com.nsa.book_nsa.repository;

import com.nsa.book_nsa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
