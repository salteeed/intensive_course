package com.sk.sample.dining.product.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.dining.product.domain.model.Product;
import com.sk.sample.dining.product.domain.model.SizeType;

@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
											QueryDslPredicateExecutor<Product>{
	List<Product> findAll();
	
	Product findByName(String name);
	
	List<Product> findAll(Predicate predicate); 
	
	List<Product> findByProductDescriptionSizeType(@Param("sizeType") SizeType sizeType);
	List<Product> findByPriceValueGreaterThanEqual(@Param("value") Integer value);
	
	
}
