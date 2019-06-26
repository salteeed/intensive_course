package com.sk.sample.dining.order.domain.model;

import javax.persistence.Embeddable;

import com.sk.sample.dining.shared.base.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder
public class CreditCard implements ValueObject {
	private String cardNumber;
	private String validThru;
	
	public CreditCard(String cardNumber, String validThru) {
		this.cardNumber = cardNumber;
		this.validThru = validThru;
	}
}
