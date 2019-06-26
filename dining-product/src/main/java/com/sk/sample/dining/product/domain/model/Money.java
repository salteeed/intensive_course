package com.sk.sample.dining.product.domain.model;

import javax.persistence.Embeddable;

import com.sk.sample.dining.shared.base.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class Money implements ValueObject {
	private int value;
	
	public Money(Integer value) {
		this.value = value;
	}
}
