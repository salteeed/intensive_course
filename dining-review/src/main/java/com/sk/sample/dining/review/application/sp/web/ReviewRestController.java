package com.sk.sample.dining.review.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.dining.review.domain.model.Review;
import com.sk.sample.dining.review.domain.service.ReviewService;

@RestController
@RequestMapping("/v1/menus")
public class ReviewRestController implements ReviewService {
	@Autowired
	private ReviewService reviewService;

	@Override
	@GetMapping
	public List<Review> findAll() {
		return reviewService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Review findById(@PathVariable("id") Long id) {
		return reviewService.findById(id);
	}

	@Override
	@PostMapping
	public Review register(@RequestBody Review review) {
		return reviewService.register(review);
	}

	@Override
	@PutMapping("/{id}")
	public Review update(@PathVariable("id") Long id, @RequestBody Review review) {
		return reviewService.update(id, review);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		reviewService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Review> findByReviewTypeLike(@RequestParam("name") String name) {
		return reviewService.findByReviewTypeLike(name);
	}

	@Override
	@GetMapping("/search/reviewType")
	public Review findByReviewType(@RequestParam("menuType") String reviewType) {
		return reviewService.findByReviewType(reviewType);
	}

	@Override
	//@GetMapping
	public Page<Review> findAll(Pageable pageable) {
		return reviewService.findAll(pageable); 
	}


}
