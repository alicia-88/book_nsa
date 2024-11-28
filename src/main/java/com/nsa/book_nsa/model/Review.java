package com.nsa.book_nsa.model;

import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rev_id")
	private Long id;

	@Column(name = "rev_date")
	@NotBlank(message = "La date doit etre renseigné")
	private Date date;

	@Column(name = "rev_post", length = 255, nullable = false)
	@NotBlank(message = "Le post doit etre renseigné")
	private String post;

	@Column(name = "rev_rating", nullable = false)
	@NotBlank(message = "La note doit etre renseigné")
	@Min(value = 1, message = "La valeur minimum doit etre 1")
	@Max(value = 1, message = "La valeur minimum doit etre 1")
	private int rating;

	@ManyToOne
	@JoinColumn(name = "boo_id", nullable = false)
	private Book book;

	@ManyToOne
	@JoinColumn(name = "use_id", nullable = false)
	private User user;

	public Review() {

	}

	public Review(Date date, String post, int rating, Book book, User user) {

		this.date = date;
		this.post = post;
		this.rating = rating;
		this.book = book;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
