package com.sk.sample.dining.payment.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Purchase extends AbstractEntity implements AggregateRoot {
	private CreditCard creditCard;
	private Integer purchasedAmount;
	private Boolean successed;
	private Date purchasedDate;
	
	public Purchase(CreditCard creditCard, Integer purchasedAmount) {
		this.creditCard = creditCard;
		this.purchasedAmount = purchasedAmount;
		this.successed = false;
		this.purchasedDate = new Date();
	}
}
