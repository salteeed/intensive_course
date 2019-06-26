package com.sk.sample.dining.product.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.dining.product.domain.model.Product;
import com.sk.sample.dining.product.domain.repository.ProductRepository;

@Service("productLogic")
public class ProductLogic implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	@Transactional
	public Product register(Product product) {
		//등록 전에 특정 경우에만 추가 처리가 필요한 경우들이 있어ㅓㅅ 로직이 필요한 것
//		if(product.getProductDescription().getSizeType() == SizeType.XL) {
//			
//		}
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		Product result = productRepository.findOne(id);
		return result;
	}

	@Override
	@Transactional
	public Product update(Long id, Product newProduct) {
		Product oldProduct = productRepository.findOne(id);
		if(oldProduct == null) {
			return null;
		}
		oldProduct.setName(newProduct.getName());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setProductDescription(newProduct.getProductDescription());
		return productRepository.save(oldProduct);
//		if(oldProduct != null) {
//			BeanUtils.copyProperties(newProduct,  oldProduct, "id"); 
//			return productRepository.save(oldProduct);
//		} else {
//			return null;
//		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
