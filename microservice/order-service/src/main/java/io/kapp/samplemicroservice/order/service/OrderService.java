package io.kapp.samplemicroservice.order.service;

import java.util.List;

import io.kapp.samplemicroservice.order.data.domain.Order;

public interface OrderService {
	Order getById(Long id);	
	Order save(Order order);
	void remove(Order order);
	void remove(Long id);	
	List<Order> getAll();
	
}
