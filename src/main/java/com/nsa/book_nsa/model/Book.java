package com.nsa.book_nsa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
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

    @ManyToOne
    @JoinColumn(name = "aut_id", nullable = false)
    @JsonBackReference(value = "author-books")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonBackReference(value = "category-books")
    private Category category;

    public Book() {
    }

    public Book(String title, String synopsis, Double price, Date releaseYear, String coverImage,Author author, Category category) {
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.releaseYear = releaseYear;
        this.coverImage = coverImage;
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

}
