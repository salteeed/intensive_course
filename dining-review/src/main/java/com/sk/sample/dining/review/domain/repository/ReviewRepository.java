package com.sk.sample.dining.review.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.dining.review.domain.model.Review;

@RepositoryRestResource
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>,
                                           QueryDslPredicateExecutor<Review> {
	Review findById(@Param("id") Long id);
	Review findByReviewType(@Param("reviewType") String reviewType);
	List<Review> findByReviewTypeLike(@Param("name") String name);
	List<Review> findAll();
	List<Review> findAll(Predicate predicate); 
}
