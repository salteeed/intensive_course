package com.sk.sample.dining.pay.domain.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.dining.pay.domain.model.Pay;
import com.sk.sample.dining.pay.domain.repository.PayRepository;

@Service("accountLogic")
public class PayLogic implements PayService {
	@Autowired
	private PayRepository payRepository;

	@Override
	@Transactional(readOnly=true)
	public Pay findById(Long id) {
		return payRepository.findOne(id);
	}

//	@Override
//	@Transactional(readOnly=true)
//	public List<Account> findByNameLike(String name) {
//		return accountRepository.findByNameLike(name);
//	}
//
//	@Override
//	@Transactional(readOnly=true)
//	public Account findByEmail(String email) {
//		return accountRepository.findByEmail(email);
//	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Pay> findAll() {
		return payRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Pay> findAll(Pageable pageable) {
		return payRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Pay register(Pay pay) {
		return payRepository.save(pay);
	}
//
//	@Override
//	@Transactional
//	public Account update(Long id, Account newAccount) {
//		Account oldAccount = accountRepository.findOne(id);
//		if(oldAccount != null) {
//			BeanUtils.copyProperties(newAccount,  oldAccount, "id");
//			return accountRepository.save(oldAccount);
//		} else {
//			return null;
//		}
//	}

	@Override
	@Transactional
	public void delete(Long id) {
		payRepository.delete(id);
	}

	@Override
	public List<Pay> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pay findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pay update(Long id, Pay pay) {
		// TODO Auto-generated method stub
		return null;
	}
}
