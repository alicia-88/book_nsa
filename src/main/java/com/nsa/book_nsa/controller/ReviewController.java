package com.nsa.book_nsa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsa.book_nsa.model.Review;
import com.nsa.book_nsa.service.ReviewService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {

		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<?> getAllReviews() {
		List<Review> reviews = reviewService.getAllReviews();
		return ResponseEntity.ok(reviews);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getReviewById(@PathVariable("id") Long id) {
		Review review = reviewService.getReviewById(id);
		return ResponseEntity.ok(review);
	}

	@PostMapping
	public ResponseEntity<?> addReview(@Valid @RequestBody Review reviewDetails) {
		Review review = reviewService.addReview(reviewDetails);
		return ResponseEntity.status(201).body(review);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateReview(@PathVariable("id") Long id, @Valid @RequestBody Review reviewDetails) {
		Review review = reviewService.updateReview(id, reviewDetails);
		return ResponseEntity.ok(review);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReviewById(@PathVariable("id") Long id) {
		reviewService.deleteReviewById(id);
		return ResponseEntity.noContent().build();
	}

}
