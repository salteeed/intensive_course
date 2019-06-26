package com.sk.sample.dining.product.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.dining.product.domain.model.Product;
import com.sk.sample.dining.product.domain.model.QProduct;
import com.sk.sample.dining.product.domain.model.SizeType;
import com.sk.sample.dining.product.domain.repository.ProductRepository;
import com.sk.sample.dining.product.domain.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductRestController implements ProductService{
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public ProductService productService;

	@PutMapping("/test")
	public List<Product> test() {
		return productRepository.findAll(QProduct.product.productDescription.sizeType.eq(SizeType.M));
	}

	@Override
	@PostMapping
	public Product register(@RequestBody Product product) {
		return productService.register(product);
	}

	@Override
	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@Override
	@PutMapping("/{id}")
	public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.update(id, product);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		productService.delete(id);
	}
}
