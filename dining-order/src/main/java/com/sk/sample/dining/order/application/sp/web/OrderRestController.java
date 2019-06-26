package com.sk.sample.dining.order.application.sp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.dining.order.domain.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController implements OrderService {
	
	
	@Override
	public void purchase(Long orderId) {
		// TODO Auto-generated method stub
		
	}

}
