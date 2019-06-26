package com.sk.sample.dining.review.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.dining.review.domain.model.Review;

public interface ReviewService {
	Review findById(Long id);
	Review findByReviewType(String reviewType);
	List<Review> findAll();
	Page<Review> findAll(Pageable pageable);	
	List<Review> findByReviewTypeLike(String name);	
	Review register(Review menu);
	Review update(Long id, Review menu);
	void delete(Long id);
}
