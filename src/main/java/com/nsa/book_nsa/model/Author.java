package com.nsa.book_nsa.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "author") // Associe cette classe à la table SQL "Author"
public class Author  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
	@Column(name = "aut_id")
	private int id;
	@OneToMany(mappedBy = "author")
	@JsonManagedReference
	private List<Book> books;
	@NotNull 
	@Column(name = "aut_lastname", nullable = false, length = 250)
	@NotBlank(message = "Last name cannot be blank") // Non vide et non nul
	@Size(max = 250, message = "Last name must be at most 250 characters")
	private String lastName;

	@Column(name = "aut_firstname", nullable = false, length = 250)
	@NotBlank(message = "First name cannot be blank")
	@Size(max = 250, message = "First name must be at most 250 characters")
	private String firstName;
	
	@Column(name = "aut_birtdate", nullable = false)
//	@NotBlank(message = "Birth date cannot be null")
	@Past(message = "Birth date must be in the past") // Doit être une date passée
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "aut_nationality", nullable = false, length = 250)
	@NotBlank(message = "Nationality cannot be blank")
	@Size(max = 250, message = "Nationality must be at most 250 characters")
	private String nationality;
	
	// Constructeurs

	public Author() {
	}

	public Author(String lastName, String firstName, Date birthDate, String nationality) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}

	// Getters et Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	// Méthode toString pour afficher l'objet sous forme de chaîne
//	@Override
//	public String toString() {
//		return "Author{" + "id=" + id + ", lastName='" + lastName + '\'' + ", firstName='" + firstName + '\''
//				+ ", birthDate=" + birthDate + ", nationality='" + nationality + '\'' + '}';
//	}
}
