package com.nsa.book_nsa.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
<<<<<<< develop
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
=======
public class Order {

    @Id
    @Column(name = "ord_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> ajout class order et line
    private Long id;

    @Column(name = "ord_date")
    private Date date;

    @Column(name = "ord_quantity")
    private int quantity;

    @Column(name = "ord_total")
    private double total;

    @OneToMany(mappedBy = "order")
    private List<Line> line;

//    @ManyToOne
//    @JoinColumn(name = "use_id", nullable = false)
//    private User user;

    public Order() {
    }

    public Order(Date date, int quantity, double total, List<Line> line) {
       this.date = date;
       this.quantity = quantity;
       this.total = total;
       this.line = line;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setLine(List<Line> line) {
        this.line = line;
    }

    public List<Line> getLine() {
        return line;
    }

}
