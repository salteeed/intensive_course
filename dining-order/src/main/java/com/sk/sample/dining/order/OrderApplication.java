package com.sk.sample.dining.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.sample.dining.order.domain.model.CreditCard;
import com.sk.sample.dining.order.domain.model.Order;
import com.sk.sample.dining.order.domain.repository.OrderRepository;
import com.sk.sample.dining.order.domain.service.OrderService;
import com.sk.sample.dining.shared.domain.Address;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
		System.out.println("***0000*********************");
	}
	
	@Bean
	public CommandLineRunner createSampleData(OrderRepository  orderRepository, @Qualifier("orderLogic") OrderService orderService) {
		return (args) -> {
			System.out.println("***************************************************************");
			Order order = new Order(1L, 1L, 3);
			orderRepository.save(order);
			
			orderService.purchase(order.getId());
			
			order.setCreditCard(new CreditCard("1234567", "1021"));
			orderRepository.save(order);
			orderService.purchase(order.getId());
			
			order.setShippingAddress(new Address(12345, "부산"));
			orderRepository.save(order);
			orderService.purchase(order.getId());
		};
		
	}
	
}
