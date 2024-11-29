package com.nsa.book_nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsa.book_nsa.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
public User findByEmail(String email);
public User findByUsername(String username);
}
