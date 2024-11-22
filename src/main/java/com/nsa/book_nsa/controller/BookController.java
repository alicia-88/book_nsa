package com.nsa.book_nsa.controller;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Author;
import com.nsa.book_nsa.model.Book;
import com.nsa.book_nsa.service.AuthorService;
import com.nsa.book_nsa.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category) {
        List<Book> books = bookService.searchBook(title, author, category);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Author findAuthor = authorService.getAuthorById(book.getAuthor().getId());
        if(findAuthor == null) {
            throw new NotFoundException("author", book.getAuthor().getId());
        }
        Book createdBook = bookService.addBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id,@Valid @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
