package com.sk.sample.dining.order.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.dining.order.application.proxy.feign.AccountProxy;
import com.sk.sample.dining.order.application.proxy.feign.ProductProxy;
import com.sk.sample.dining.order.application.proxy.feign.dto.account.Account;
import com.sk.sample.dining.order.application.proxy.feign.dto.product.Product;
import com.sk.sample.dining.order.domain.model.Order;
import com.sk.sample.dining.order.domain.repository.OrderRepository;

@Service("orderLogic")
public class OrderLogic implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	AccountProxy accountProxy;
	
	@Autowired
	ProductProxy productProxy;

	@Override
	@Transactional
	public void purchase(Long orderId) {
		Order order = orderRepository.findOne(orderId);
		
		if(order == null) {
			System.out.println("no order");
			return;
		}
		if(order.getShippingAddress() == null) {
			System.out.println("no shipping address");
			return;
		}
		if(order.getCreditCard() == null) {
			System.out.println("no credit card info");
			return;
		}
		Account account = accountProxy.findAccount(order.getBuyerAccountId());
		System.out.println("Buyer: "+ account.toString());
		
		Product product = productProxy.findProduct(order.getProductId());
		System.out.println("Product: "+ product.toString());
		
		Integer totalPrice = product.getPrice().getValue() * order.getProductCount();
		System.out.println("product.getPrice().getValue() : "+ product.getPrice().getValue());
		System.out.println("totalPrice: "+totalPrice);
		order.setTotalPrice(totalPrice);
		order.setPurchased(true);
		orderRepository.save(order);
		
	}

}
