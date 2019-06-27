package com.sk.sample.dining.pay.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.dining.pay.domain.model.Pay;
import com.sk.sample.dining.pay.domain.service.PayService;

@RestController
@RequestMapping("/v1/Pays")
public class PayRestController implements PayService {
	@Autowired
	private PayService PayService;

	@Override
	@GetMapping
	public List<Pay> findAll() {
		return PayService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Pay findById(@PathVariable("id") Long id) {
		return PayService.findById(id);
	}

	@Override
	@PostMapping
	
	public Pay register(@RequestBody Pay Pay) {
		return PayService.register(Pay);
	}
//	public Pay register(@RequestBody Pay Pay) {
//		return PayService.register(Pay);
//	}
//
//	@Override
//	@PutMapping("/{id}")
//	public Pay update(@PathVariable("id") Long id, @RequestBody Pay Pay) {
//		return PayService.update(id, Pay);
//	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		PayService.delete(id);
	}
	
//	@Override
//	@GetMapping("/search/name")
//	public List<Pay> findByNameLike(@RequestParam("name") String name) {
//		return PayService.findByNameLike(name);
//	}

//	@Override
//	@GetMapping("/search/email")
//	public Pay findByEmail(@RequestParam("email") String email) {
//		return PayService.findByEmail(email);
//	}

	@Override
	//@GetMapping
	public Page<Pay> findAll(Pageable pageable) {
		return PayService.findAll(pageable); 
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

//	@Override
//	public Pay register(Pay Pay) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Pay update(Long id, Pay Pay) {
		// TODO Auto-generated method stub
		return null;
	}


}
