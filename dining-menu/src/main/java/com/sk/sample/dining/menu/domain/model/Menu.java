package com.sk.sample.dining.menu.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.dining.menu.domain.model.Money;
import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Menu extends AbstractEntity implements AggregateRoot {
	private Money price;
	
	@Enumerated(EnumType.STRING)
	private MenuType menuType;

	@Enumerated(EnumType.STRING)
	private MealTime mealTime;
	
	@Enumerated(EnumType.STRING)
	private ReviewType reviewType;

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}	
	
	public Menu() {
		
	}
	
	public String toString() {
		return " menuType: "+ this.menuType +" mealTime: "+this.mealTime+ " price: " + this.price +" reviewType: "+ this.reviewType;
		
	}

//	public Menu(MenuType menuType, MealTime mealTime, Long price) {
//		this(menuType, mealTime, price);
//	}

	public Menu(MenuType menuType, MealTime mealTime, Money price, ReviewType reviewType) {		
		this.menuType = menuType;
		this.mealTime = mealTime;
		this.price = price;
		this.reviewType = reviewType;
	}
}
