package io.kapp.samplemicroservice.order.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kapp.samplemicroservice.order.data.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findFirstByusername(String username);
}
