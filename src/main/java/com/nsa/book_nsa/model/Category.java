package com.nsa.book_nsa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name= "category")
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cat_id")
	private Long id;

	@OneToMany(mappedBy = "category")
	@JsonManagedReference
	private List<Book> books;
	
	@Column(name = "cat_name", nullable = false)
	private String name;


	public Category() {
	}
	
	public Category(Long id, String name) {
		super();
		this.id= id;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
