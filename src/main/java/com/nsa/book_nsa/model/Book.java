package com.nsa.book_nsa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book", uniqueConstraints = {@UniqueConstraint(columnNames = {"book_isbn"})})
public class Book  {

    @Id
    @Column(name = "boo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boo_title", nullable = false)
    @NotBlank(message = "Le nom du livre est obligatoire.")
    private String title;

    @Column(name = "boo_synopsis")
    private String synopsis;

    @Column(name = "boo_price")
    @DecimalMin(value = "0.0", message = "Le prix doit être supérieur à 0.")
    private Double price;

    @Column(name = "boo_release_year")
    private Date releaseYear;

    @Column(name = "boo_cover_image")
    private String coverImage;

    @Column(name = "boo_isbn", unique = true, nullable = false)
    @Size(min = 10, max = 13, message = "L'ISBN doit être de 10 ou 13 caractères.")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "aut_id", nullable = false)
    @JsonBackReference(value = "author-books")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonBackReference(value = "category-books")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Stock> stocks;


    public Book() {
    }

    public Book(String title, String synopsis, Double price, Date releaseYear, String coverImage, String isbn, Author author, Category category) {
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.releaseYear = releaseYear;
        this.coverImage = coverImage;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public List<Stock> getStocks() {
        return stocks;
    }
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
