package com.sk.sample.dining.product.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.dining.shared.base.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class ProductDescription implements ValueObject {
	@Enumerated(EnumType.STRING)
	private ColorType colorType;
	
	@Enumerated(EnumType.STRING)
	private SizeType sizeType;
	
	public ProductDescription(ColorType colorType, SizeType sizeType) {
		this.colorType = colorType;
		this.sizeType = sizeType;
	}
}
