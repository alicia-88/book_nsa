package com.nsa.book_nsa.model;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "boo_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "for_id", nullable = false)
    private Format format;



}
