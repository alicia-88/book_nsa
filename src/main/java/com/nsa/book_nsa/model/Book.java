package com.nsa.book_nsa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book", uniqueConstraints = {@UniqueConstraint(columnNames = {"book_isbn"})})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title", nullable = false)
    @NotBlank(message ="Le nom du livre est obligatoire.")
    private String title;

    @Column(name = "book_synopsis")
    private String synopsis;

    @Column(name = "book_price")
    @DecimalMin(value = "0.0", message = "Le prix doit être supérieur à 0.")
    private Double price;

    @Column(name = "book_release_year")
    private Date releaseYear;

    @Column(name = "book_cover_image")
    private String coverImage;

    @Column(name = "book_isbn", unique = true, nullable = false)
    @Size(min = 10, max = 13, message = "L'ISBN doit être de 10 ou 13 caractères.")
    private String isbn;

//    @ManyToOne
//    @JoinColumn(name = "aut_id", nullable = false)
//    @JsonBackReference
//    private Author author;


    public Book() {
    }

    public Book(Long id, String title, String synopsis, Double price, Date releaseYear, String coverImage, String isbn) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.releaseYear = releaseYear;
        this.coverImage = coverImage;
        this.isbn = isbn;
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

}
