package com.sk.sample.dining.review.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.dining.review.domain.model.Review;
import com.sk.sample.dining.review.domain.repository.ReviewRepository;

@Service("menuLogic")
@Primary
public class ReviewLogic implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	@Transactional(readOnly=true)
	public Review findById(Long id) {
		return reviewRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Review> findByReviewTypeLike(String name) {
		return reviewRepository.findByReviewTypeLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Review findByReviewType(String reviewType) {
		return reviewRepository.findByReviewType(reviewType);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Review> findAll(Pageable pageable) {
		return reviewRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Review register(Review menu) {
		return reviewRepository.save(menu);
	}

	@Override
	@Transactional
	public Review update(Long id, Review newMenu) {
		Review oldMenu = reviewRepository.findOne(id);
		if(oldMenu != null) {
			BeanUtils.copyProperties(newMenu,  oldMenu, "id");
			return reviewRepository.save(oldMenu);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		reviewRepository.delete(id);
	}
}
