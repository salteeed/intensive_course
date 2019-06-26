package com.sk.sample.dining.product;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.querydsl.core.types.Predicate;
import com.sk.sample.dining.product.domain.model.ColorType;
import com.sk.sample.dining.product.domain.model.Money;
import com.sk.sample.dining.product.domain.model.Product;
import com.sk.sample.dining.product.domain.model.ProductDescription;
import com.sk.sample.dining.product.domain.model.QProduct;
import com.sk.sample.dining.product.domain.model.SizeType;
import com.sk.sample.dining.product.domain.repository.ProductRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execExample1(ProductRepository productRepository) {	
		return (args) -> {
			insertProducts(productRepository);
			displayProducts(productRepository);
			
			execExample2(productRepository);
			execExample3(productRepository);
			execExample4(productRepository);
			execExample5(productRepository);
			execExample6(productRepository);
			execExample7(productRepository);
		};
	}
	//1-1)
	public void insertProducts(ProductRepository productRepository) {
		System.out.println("****** 1) 제품등록 하고 리스트 출력");
		Product product1 = new Product("Iron Man", new Money(30000), new ProductDescription(ColorType.RED, SizeType.L));
		productRepository.save(product1);
		
		Product product2 = new Product("Captin America", new Money(20000), new ProductDescription(ColorType.BLUE, SizeType.M));
		productRepository.save(product2);
		
		Product product3 = new Product("Winter Soldier", new Money(15000), new ProductDescription(ColorType.YELLOW, SizeType.M));
		productRepository.save(product3);
	}
	//1-2)
	public void displayProducts(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Product> productList = productRepository.findAll();
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
	}
	// 2) 제품명이 "Iron Man"인 제품의 금액을 25000으로 수정하고 결과 출력
	public void execExample2(ProductRepository productRepository) {
		System.out.println("****** 2) 제품명이 Iron Man인 제품의 금액을 25000으로 수정하고 결과 출력");
		Product product = productRepository.findByName("Iron Man");
		product.setPrice(new Money(25000));
		productRepository.save(product);
		
		System.out.println(productRepository.findOne(QProduct.product.price.value.eq(25000)).toString());
	}
	
	// 3) 사이즈 M인것 찾기
	public void execExample3(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		System.out.println("****** 3) 사이즈 M인것 찾기");
		List<Product> productList =  productRepository.findAll(QProduct.product.productDescription.sizeType.eq(SizeType.M));
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
	}
	
	// 4) 블루 색상 찾기
	public void execExample4(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		System.out.println("****** 4) 블루 색상 찾기");
		List<Product> productList =  productRepository.findAll(QProduct.product.productDescription.colorType.eq(ColorType.BLUE));
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
	}
	
	
	// 5)  금액 17000 이상
	public void execExample5(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		System.out.println("****** 5) 금액17000 이상");
		List<Product> productList =  productRepository.findAll(QProduct.product.price.value.between(17000, null));
//		List<Product> productList =  productRepository.findAll(QProduct.product.price.value.goe(170000));
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
	}
	
	// 6) 금액 21000 이하
	public void execExample6(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		System.out.println("****** 6) 금액 21000 이하");
		List<Product> productList =  productRepository.findAll(QProduct.product.price.value.loe(21000));
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
	}
	
	public void execExample7(ProductRepository productRepository) {
		System.out.println("***************************************************************");
		System.out.println("****** 7) 금액 10000 보다 크고 20000 미만인 제품");
		List<Product> productList =  productRepository.findAll(QProduct.product.price.value.gt(10000).and(QProduct.product.price.value.lt(20000)));
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		System.out.println("***************************************************************");
//		Predicate predicate = productRepository.coun 
	}
	
	
	
}
