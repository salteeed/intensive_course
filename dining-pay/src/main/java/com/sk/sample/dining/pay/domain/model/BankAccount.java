package com.sk.sample.dining.pay.domain.model;

import javax.persistence.Embeddable;

import com.sk.sample.dining.shared.base.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class BankAccount implements ValueObject {
	//private Integer zipCode;
	//private String homeAddress;
	
	private String bankAccountNum; 
	private String bankBalance;
	
	
	public BankAccount() {
	}
	
	//public BankAccount(Integer zipCode, String homeAddress) {
	public BankAccount(String bankAccountNum, String bankBalance) {
		//this.zipCode = zipCode;
		//this.homeAddress = homeAddress;
		
		this.bankAccountNum = bankAccountNum;
		this.bankAccountNum = bankBalance;
	}
}
