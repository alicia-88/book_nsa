package com.nsa.book_nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsa.book_nsa.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	

}
