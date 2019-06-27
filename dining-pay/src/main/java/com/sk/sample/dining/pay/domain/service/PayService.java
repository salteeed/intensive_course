package com.sk.sample.dining.pay.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.dining.pay.domain.model.Pay;

public interface PayService {
	Pay findById(Long id);
	List<Pay> findAll();
	Page<Pay> findAll(Pageable pageable);
	
	List<Pay> findByNameLike(String name);
	Pay findByEmail(String email);
	
	Pay register(Pay pay);
	Pay update(Long id, Pay pay);

	void delete(Long id);
}
