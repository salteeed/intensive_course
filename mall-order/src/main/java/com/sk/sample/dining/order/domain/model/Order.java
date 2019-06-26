package com.sk.sample.dining.order.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;
import com.sk.sample.dining.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@Table(name="order_t")
public class Order extends AbstractEntity implements AggregateRoot{
	private Long buyerAccountId;
	private Long productId;
	private Integer productCount;
	private CreditCard creditCard;
	private Address shippingAddress;
	private Integer totalPrice;
	private Boolean purchased = false;
	
	public Order(Long buyerAccountId, Long productId, Integer productCount) {
		this.buyerAccountId = buyerAccountId;
		this.productId = productId;
		this.productCount = productCount;
	}

}
