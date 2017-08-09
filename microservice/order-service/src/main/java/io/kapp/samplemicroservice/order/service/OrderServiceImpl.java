package io.kapp.samplemicroservice.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kapp.samplemicroservice.order.data.domain.Order;
import io.kapp.samplemicroservice.order.data.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order getById(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void remove(Order order) {
		orderRepository.delete(order);
	}

	@Override
	public void remove(Long id) {
		orderRepository.delete(id);
	}

	@Override
	public List<Order> getAll() {	
		return orderRepository.findAll();
	}

}
