package com.sk.sample.dining.pay.domain.model;

import javax.persistence.Embeddable;



import com.sk.sample.dining.shared.base.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class Buyer implements ValueObject {
	//private Integer zipCode;
	//private String homeAddress;
	
	private String name; 

	private String companyType;
	private String workType;
	
	
	public Buyer() {
	}
	
	//public BankAccount(Integer zipCode, String homeAddress) {
	public Buyer(String name, String companyType, String workType) {
		//this.zipCode = zipCode;
		//this.homeAddress = homeAddress;
		this.name = name;
		this.companyType=companyType;
		this.workType = workType;
//		this.bankAccountNum = bankAccountNum;
//		this.bankAccountNum = bankBalance;
	}
}
