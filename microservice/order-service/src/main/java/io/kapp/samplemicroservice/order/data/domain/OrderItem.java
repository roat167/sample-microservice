package io.kapp.samplemicroservice.order.data.domain;

import javax.persistence.Embeddable;

/**
 * This class represent amount of a certain item in shopping
 */
@Embeddable
public class OrderItem {
	private Long id;
	private double price;
	private int amount;

	public OrderItem() {
	}

	public OrderItem(Long id, double price, int amount) {
		this.id = id;
		this.price = price;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("id = %tl, price = %f, amount=%d]", this.id, this.price, this.amount);
	}
}
