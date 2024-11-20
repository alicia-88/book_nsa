package com.nsa.book_nsa.service;

import com.nsa.book_nsa.model.Book;
import com.nsa.book_nsa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        Book deletedBook = getBookById(id);
        if (deletedBook != null) {
            bookRepository.deleteById(deletedBook.getId());
        }
    }

    public Book updateBook(Book bookDetails) {
        Book updatedBook = getBookById(bookDetails.getId());
        if (updatedBook != null) {
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setIsbn(bookDetails.getIsbn());
            updatedBook.setPrice(bookDetails.getPrice());
            updatedBook.setCoverImage(bookDetails.getCoverImage());
            return bookRepository.save(updatedBook);
        }
        return null;
    }

}
