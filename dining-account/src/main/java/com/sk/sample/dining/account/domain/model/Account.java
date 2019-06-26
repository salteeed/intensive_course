package com.sk.sample.dining.account.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.dining.shared.base.AbstractEntity;
import com.sk.sample.dining.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Account extends AbstractEntity implements AggregateRoot {
	//private String email;
	//id는 Abstract에서..
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	
	@Enumerated(EnumType.STRING)
	private WorkType workType;
	
	private BankAccount bankAccount;	

	/*
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;

	private Address address;

	public void setEmail(String email) {
		this.email = email;
	}
	*/
	public void setName(String name) {
		this.name = name;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}
	
	
	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public Account() {
		
	}

	//public Account(String email, String name, MemberType memberType) {
	public Account(String name, CompanyType companyType, BankAccount bankAccount) {
		//this(email, name, memberType, MembershipLevelType.SILVER);
		this(name, companyType, WorkType.WORKING, bankAccount);
	}

	//public Account(String email, String name, MemberType memberType, MembershipLevelType membershipLevelType) {
	public Account(String name, CompanyType companyType, WorkType workType, BankAccount bankAccount) {
		//this.email = email;
		this.name = name;
		this.companyType = companyType;
		this.workType = workType;
		this.bankAccount = bankAccount;
		
		
		//this.memberType = memberType;
		//this.membershipLevelType = membershipLevelType;
	}
}
