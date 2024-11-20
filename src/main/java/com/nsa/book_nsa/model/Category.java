package com.nsa.book_nsa.model;

import jakarta.persistence.*;


@Entity
@Table(name= "Category")
public class Category {

	
	@Id
	@GeneratedValue
	private Long cat_id;
	
	
	@Column(name = "cat_name", nullable = false)
	private String name;


	public Category() {
	}
	
	public Category(Long id, String category) {
		super();
		cat_id = id;
		this.name = category;
	}


	public Long getId() {
		return cat_id;
	}


	public void setId(Long id) {
		cat_id = id;
	}


	public String getCategory() {
		return name;
	}


	public void setCategory(String category) {
		this.name = category;
	}
	
	
	
}
