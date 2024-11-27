package com.nsa.book_nsa.service;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Book;
import com.nsa.book_nsa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookService(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    public List<Book> searchBook(String title) {
        if (title != null) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        }
        throw new IllegalArgumentException("Au moins un paramètre de recherche doit être fourni.");
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("book", id));
    }

    public Book addBook(Book bookDetails) {
        authorService.getAuthorById(bookDetails.getAuthor().getId());
        categoryService.getCategoryById(bookDetails.getCategory().getId());
        return bookRepository.save(bookDetails);
    }

    public void deleteBookById(Long id) {
        Book deletedBook = getBookById(id);
        bookRepository.deleteById(deletedBook.getId());
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book updatedBook = getBookById(id);
        authorService.getAuthorById(bookDetails.getAuthor().getId());
        categoryService.getCategoryById(bookDetails.getCategory().getId());
        updatedBook.setTitle(bookDetails.getTitle());
        updatedBook.setPrice(bookDetails.getPrice());
        updatedBook.setCoverImage(bookDetails.getCoverImage());
        return bookRepository.save(updatedBook);
    }

}
