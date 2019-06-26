package com.sk.sample.dining.product.domain.service;

import com.sk.sample.dining.product.domain.model.Product;

public interface ProductService {
	Product register(Product product);
	
	Product findById(Long id);
	
	Product update(Long id, Product product);
	
	void delete(Long id);
}
