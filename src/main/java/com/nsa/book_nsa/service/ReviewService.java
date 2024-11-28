package com.nsa.book_nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Book;
import com.nsa.book_nsa.model.Review;
import com.nsa.book_nsa.model.User;
import com.nsa.book_nsa.repository.ReviewRepository;

@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final UserService userService;
	private final BookService bookService;
	
	

	public ReviewService(ReviewRepository reviewRepository , UserService userService , BookService bookService ) {
		
		this.reviewRepository = reviewRepository;
		this.userService = userService;
		this.bookService = bookService;
	}
	
	
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();

	}

	public Review getReviewById(Long id) {
		return reviewRepository.findById(id).orElseThrow(() -> new NotFoundException("review", id));
	}

	public Review addReview(Review reviewDetails) {
		userService.getUserById(reviewDetails.getUser().getId());
		bookService.getBookById(reviewDetails.getBook().getId());
		return reviewRepository.save(reviewDetails);
	}

	public void deleteReviewById(Long id) {
		Review review = getReviewById(id);
		reviewRepository.deleteById(review.getId());
	}

	public Review updateReview(Long id , Review reviewDetails) {
		userService.getUserById(reviewDetails.getUser().getId());
		bookService.getBookById(reviewDetails.getBook().getId());
		Review review = getReviewById(id);
		review.setPost(reviewDetails.getPost());
		review.setDate(reviewDetails.getDate());
		return reviewRepository.save(review);
	}
	
	
	
	
	
	
	
	
	

}
