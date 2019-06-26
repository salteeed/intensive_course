package com.sk.sample.dining.payment.domain.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.sk.sample.dining.payment.domain.model.Purchase;

@RepositoryRestResource
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long>, 
	                                        QueryDslPredicateExecutor<Purchase> {
	@RestResource(exported=false)
	<S extends Purchase> S save(S purchase);
}
