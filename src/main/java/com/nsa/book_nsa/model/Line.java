package com.nsa.book_nsa.model;

import jakarta.persistence.*;

@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lin_id")
    private Long id;

    @Column(name = "lin_quantity")
    private int quantity;

    @Column(name = "lin_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "boo_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "ord_id", nullable = false)
    private Order order;

    public Line() {
    }

    public Line(int quantity, double price, Book book, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.book = book;
        this.order = order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}
