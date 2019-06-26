package com.sk.sample.dining.review.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.dining.review.domain.model.MealTime;
import com.sk.sample.dining.review.domain.model.MenuType;
import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Review extends AbstractEntity implements AggregateRoot {
	
	@Enumerated(EnumType.STRING)
	private MenuType menuType;

	@Enumerated(EnumType.STRING)
	private MealTime mealTime;
	
	@Enumerated(EnumType.STRING)
	private ReviewType reviewType;

//	public void setReviewType(MenuType menuType, MealTime mealTime, ReviewType reviewType) {
//		this.menuType = menuType;
//		this.mealTime = mealTime;
//		this.reviewType = reviewType;
//	}	
	
	public Review() {
		
	}
	
	public String toString() {
		return " MenuType: "+ this.menuType +" MealTime: "+this.mealTime+" ReviewType: "+ this.reviewType;
		
	}


	public Review(MenuType menuType, MealTime mealTime, ReviewType reviewType) {		
		this.menuType = menuType;
		this.mealTime = mealTime;
		this.reviewType = reviewType;
	}
}
