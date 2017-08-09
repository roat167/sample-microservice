package io.kapp.samplemicroservice.order.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.kapp.samplemicroservice.catalog.data.domain.Item;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ElementCollection
	private List<Item> products = new ArrayList<Item>();
	// private List<OrderItem> products = new ArrayList<OrderItem>();
	@NotBlank
	@Column
	private String username;
	@NotNull
	@Column
	private double totalPrice;
	@NotNull
	@Column
	private long createTime;
	@NotNull
	@Column
	private OrderStatus orderStatus;

	public Order() {
	}

	public Order(String username, List<Item> products, double totalPrice, OrderStatus orderStatus) {
		this.username = username;
		this.products = products;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}

	public Order(Long id, String username, List<Item> products, double totalPrice, OrderStatus orderStatus) {
		this.id = id;
		this.username = username;
		this.products = products;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getProducts() {
		return products;
	}

	public void setProducts(List<Item> products) {
		this.products = products;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return String.format("Item  [id = %tl, name = %s, price = %f, created = %tl, status=%s]", this.id,
				this.username, this.totalPrice, this.createTime, this.orderStatus);
	}
}
