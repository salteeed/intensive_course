package com.sk.sample.dining.review;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.sk.sample.dining.review.domain.model.MealTime;
import com.sk.sample.dining.review.domain.model.MenuType;
import com.sk.sample.dining.review.domain.model.Review;
import com.sk.sample.dining.review.domain.model.ReviewType;
import com.sk.sample.dining.review.domain.repository.ReviewRepository;
import com.sk.sample.dining.review.domain.service.ReviewService;

@SpringBootApplication
@EnableFeignClients
public class ReviewApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(ReviewRepository reviewRepository, ReviewService reviewService) {	
		return (args) -> {
			insertReviews(reviewRepository);
			displayReviews(reviewRepository);
		};
	}
		
	public void insertReviews(ReviewRepository reviewRepository) {
		Review Review1 = new Review(MenuType.KOREANFOOD, MealTime.LUNCH, ReviewType.BAD);
		reviewRepository.save(Review1);
		
		Review Review2 = new Review(MenuType.KOREANFOOD, MealTime.DINNER, ReviewType.GOOD);
		reviewRepository.save(Review2);
		
		Review Review3 = new Review(MenuType.NOODLEFOOD, MealTime.LUNCH, ReviewType.NORMAL);
		reviewRepository.save(Review3);
	}
	
	public void displayReviews(ReviewRepository reviewRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Review> reviewList = reviewRepository.findAll();
		for(Review review : reviewList) {
			System.out.println(review.toString());
		}
		
		System.out.println("***************************************************************");
	}
	
}
