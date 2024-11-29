package com.nsa.book_nsa.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_id")
	private Long id;

	@Column(name = "use_username", nullable = false, unique = true)
	@NotBlank(message = "Le pseudo ne doit pas être nul")
	private String username;

	@Column(name = "use_firstname")
	private String firstname;

	@Column(name = "use_lastname")
	private String lastname;

	@Column(name = "use_role", nullable = false)
	@NotBlank(message = "Le role doit etre renseigné")
	private String role;

	@Column(name = "use_birthday")
	private Date birthday;

	@Column(name = "use_email", length = 255, nullable = false, unique = true)
	@NotBlank(message = "L'email doit etre renseigné")
	@Email(message = "Adresse email valide")
	private String email;

	@Column(name = "use_password", length = 255, nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	public User() {

	}

	public User(String firstname, String lastname, String role, Date birthday, String email, String password , List<Review> reviews) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return "";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}
