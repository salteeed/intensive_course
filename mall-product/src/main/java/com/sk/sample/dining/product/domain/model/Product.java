package com.sk.sample.dining.product.domain.model;

import javax.persistence.Entity;

import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Product extends AbstractEntity implements AggregateRoot  {
	private String name;
	private Money price;
	private ProductDescription productDescription;
	
	public Product(String name, Money price, ProductDescription productDescription) {
		this.name = name;
		this.price = price;
		this.productDescription = productDescription;
	}
}
